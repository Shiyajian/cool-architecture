package com.github.shiyajian.order.infrastructure.repository.impl;

import com.github.shiyajian.cool.support.common.model.PageData;
import com.github.shiyajian.order.domain.model.aggr.WorldAggr;
import com.github.shiyajian.order.domain.model.entity.World;
import com.github.shiyajian.order.domain.model.query.WorldAggrQuery;
import com.github.shiyajian.order.domain.repository.WorldRepository;
import com.github.shiyajian.order.infrastructure.covert.db.WorldDbCovert;
import com.github.shiyajian.order.infrastructure.mapper.db.WorldDbMapper;
import com.github.shiyajian.order.infrastructure.model.db.WorldDbModel;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
@Slf4j
public class WorldRepositoryImpl implements WorldRepository {

    @Autowired
    private WorldDbMapper worldDbMapper;

    @Override
    public World findOne(Long id) {
        return null;
    }

    @Override
    public WorldAggr findOne(Long id, WorldAggrQuery.Options options) {
        return null;
    }

    @Override
    public List<World> findList(List<Long> ids) {
        return null;
    }

    @Override
    public List<WorldAggr> findList(List<Long> ids, WorldAggrQuery.Options options) {
        return null;
    }

    @Override
    public PageData<WorldAggr> findPage(WorldAggrQuery query) {
        return null;
    }

    @Override
    public void update(WorldAggr newWorld) {
        WorldDbModel worldDbModel = WorldDbCovert.fromEntity(newWorld.getRoot());
        worldDbMapper.updateById(worldDbModel);

        if (newWorld.getRefHello() != null) {
            // 更新关联的 hello
        }

    }
}
