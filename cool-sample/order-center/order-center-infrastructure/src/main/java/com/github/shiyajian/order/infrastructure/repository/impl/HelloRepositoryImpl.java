package com.github.shiyajian.order;

import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.baomidou.mybatisplus.core.toolkit.Wrappers;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.github.shiyajian.cool.support.common.enums.impl.DeletedStatus;
import com.github.shiyajian.cool.support.common.model.PageData;
import com.github.shiyajian.cool.support.infrastructure.orm.MybatisPlusUtils;
import com.github.shiyajian.cool.support.infrastructure.utils.ListHelper;
import com.github.shiyajian.order.domain.model.aggr.HelloAggr;
import com.github.shiyajian.order.domain.model.entity.Hello;
import com.github.shiyajian.order.domain.model.query.HelloAggrQuery;
import com.github.shiyajian.order.domain.repository.HelloRepository;
import com.github.shiyajian.order.infrastructure.covert.db.HelloDbCovert;
import com.github.shiyajian.order.infrastructure.covert.db.WorldDbCovert;
import com.github.shiyajian.order.infrastructure.mapper.cache.HelloCacheMapper;
import com.github.shiyajian.order.infrastructure.mapper.db.HelloDbMapper;
import com.github.shiyajian.order.infrastructure.mapper.db.WorldDbMapper;
import com.github.shiyajian.order.infrastructure.mapper.search.HelloSearchMapper;
import com.github.shiyajian.order.infrastructure.model.db.HelloDbModel;
import com.github.shiyajian.order.infrastructure.model.db.WorldDbModel;
import com.github.shiyajian.order.infrastructure.model.search.HelloSearchModel;
import com.google.common.collect.Lists;
import com.google.common.collect.Maps;
import jakarta.annotation.Resource;
import lombok.extern.slf4j.Slf4j;
import org.apache.commons.collections4.CollectionUtils;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.Map;

@Component
@Slf4j
public class HelloRepositoryImpl implements HelloRepository {

    @Resource
    private HelloDbMapper helloDbMapper;

    @Resource
    private WorldDbMapper worldDbMapper;

    @Resource
    private HelloCacheMapper helloCacheMapper;

    @Resource
    private HelloSearchMapper helloSearchMapper;

    @Override
    public Hello findOne(Long id) {
        List<Hello> hellos = findList(Lists.newArrayList(id));
        if (CollectionUtils.isEmpty(hellos)) {
            return null;
        }
        return hellos.get(0);
    }

    @Override
    public HelloAggr findOne(Long id, HelloAggrQuery.Options options) {
        List<HelloAggr> aggrs = findList(Lists.newArrayList(id), options);
        if (CollectionUtils.isEmpty(aggrs)) {
            return null;
        }
        return aggrs.get(0);
    }

    @Override
    public List<Hello> findList(List<Long> ids) {
        List<HelloAggr> list = findList(ids, new HelloAggrQuery.Options());
        if (CollectionUtils.isEmpty(list)) {
            return Lists.newArrayList();
        }
        return ListHelper.safeTransform(list, HelloAggr::getRoot);
    }

    @Override
    public List<HelloAggr> findList(List<Long> ids, HelloAggrQuery.Options options) {
        if (CollectionUtils.isEmpty(ids)) {
            return Lists.newArrayList();
        }
        HelloAggrQuery query = new HelloAggrQuery();
        query.setCurrent(1);
        query.setSize(query.getIds().size());
        PageData<HelloAggr> page = findPage(query);
        if (CollectionUtils.isEmpty(page.getList())) {
            return Lists.newArrayList();
        }
        return page.getList();
    }

    @Override
    public PageData<HelloAggr> findPage(HelloAggrQuery query) {

        if (query.getOptions() == null) {
            query.setOptions(new HelloAggrQuery.Options());
        }

        // 1、先通过 es 进行分词搜索
        PageData<HelloSearchModel> helloIndexes = helloSearchMapper.searchHello(query);
        if (CollectionUtils.isEmpty(helloIndexes.getList())) {
            return helloIndexes.mappingEmpty();
        }
        // 2、通过id 去数据库反查正式数据
        List<Long> hitIds = ListHelper.safeTransform(helloIndexes.getList(), HelloSearchModel::getId);
        LambdaQueryWrapper<HelloDbModel> queryWrapper = Wrappers.lambdaQuery();
        queryWrapper.in(CollectionUtils.isNotEmpty(hitIds), HelloDbModel::getId, hitIds);
        queryWrapper.eq(!query.getOptions().isWithDeleted(), HelloDbModel::getIsDeleted, DeletedStatus.NON_DELETE.getCode());
        Page<HelloDbModel> pageModels = helloDbMapper.selectPage(new Page<>(query.getCurrent(), query.getSize()), queryWrapper);
        if (CollectionUtils.isEmpty(pageModels.getRecords())) {
            return MybatisPlusUtils.empty(pageModels);
        }
        // 3、如果需要合并查询world，这里再查询下
        Map<Long, List<WorldDbModel>> helloWorldMap = Maps.newHashMap();
        if (query.getOptions().isWithWorld()) {
            List<Long> helloIds = ListHelper.safeTransform(pageModels.getRecords(), HelloDbModel::getId);
            // 查询world helloWorldMap = xxx
        }
        // 4、以聚合形式返回
        return MybatisPlusUtils.batchMapping(pageModels, dbModels -> HelloDbCovert.toAggrs(dbModels, helloWorldMap));
    }

    @Override
    public void create(HelloAggr hello) {
        // 插入聚合根，并回写id
        HelloDbModel helloDbModel = HelloDbCovert.fromEntity(hello.getRoot());
        helloDbMapper.insert(helloDbModel);
        hello.getRoot().setId(helloDbModel.getId());
        // 插入聚合其他信息
        if (CollectionUtils.isNotEmpty(hello.getWorlds())) {
            hello.getWorlds().forEach(world -> {
                WorldDbModel worldDbModel = WorldDbCovert.fromEntity(world);
                worldDbMapper.insert(worldDbModel);
                world.setId(worldDbModel.getId());
            });
        }
    }


}
