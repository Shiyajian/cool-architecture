package ${package};
import github.shiyajian.${rootArtifactId}.domain.repository.word.WordRepository;
import org.springframework.stereotype.Component;
import lombok.extern.slf4j.Slf4j;
import github.shiyajian.${rootArtifactId}.infrastructure.mapper.db.WordDbMapper;
import jakarta.annotation.Resource;
import github.shiyajian.${rootArtifactId}.domain.model.query.WordQuery;
import github.shiyajian.${rootArtifactId}.domain.model.aggr.WordAggr;
import java.util.List;
import com.github.shiyajian.support.common.model.page.PageData;
import org.apache.commons.collections4.CollectionUtils;
import github.shiyajian.${rootArtifactId}.infrastructure.model.db.WordDbModel;
import github.shiyajian.${rootArtifactId}.infrastructure.covert.db.word.WordDbCovert;
import com.google.common.collect.Lists;
import com.baomidou.mybatisplus.core.toolkit.Wrappers;
import com.github.shiyajian.support.infrastructure.utils.MybatisPlusUtils;
import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.github.shiyajian.support.common.enums.DeletedEnums;

@Component
@Slf4j
public class WordRepositoryImpl implements WordRepository {

    @Resource
    private WordDbMapper wordDbMapper;

    @Override
    public WordAggr findOne(Long id) {
        return findOne(id, new WordQuery.Options());
    }

    @Override
    public WordAggr findOne(Long id, WordQuery.Options options) {
        List<WordAggr> aggrs = findList(Lists.newArrayList(id), options);
        if (CollectionUtils.isEmpty(aggrs)) {
            return null;
        }
        return aggrs.get(0);
    }

    @Override
    public List<WordAggr> findList(List<Long> ids) {
        return findList(ids, new WordQuery.Options());
    }

    @Override
    public List<WordAggr> findList(List<Long> ids, WordQuery.Options options) {
        if (CollectionUtils.isEmpty(ids)) {
            return Lists.newArrayList();
        }
        WordQuery query = new WordQuery();
        query.setCurrent(1L);
        query.setPageSize((long) query.getIds().size());
        PageData<WordAggr> page = findPage(query);
        if (CollectionUtils.isEmpty(page.getList())) {
            return Lists.newArrayList();
        }
        return page.getList();
    }

    @Override
    public PageData<WordAggr> findPage(WordQuery query) {
        if (query.getOptions() == null) {
            query.setOptions(new WordQuery.Options());
        }
        LambdaQueryWrapper<WordDbModel> queryWrapper = Wrappers.lambdaQuery();
        queryWrapper.in(CollectionUtils.isNotEmpty(query.getIds()), WordDbModel::getId, query.getIds());
        queryWrapper.eq(!query.getOptions().isWithDeleted(), WordDbModel::getIsDeleted, DeletedEnums.NON_DELETE.getCode());
        Page<WordDbModel> pageModels = wordDbMapper.selectPage(new Page<>(query.getCurrent(), query.getPageSize()), queryWrapper);
        if (CollectionUtils.isEmpty(pageModels.getRecords())) {
            return MybatisPlusUtils.empty(pageModels);
        }
        // List<Long> ids = ListHelper.safeTransform(pageModels.getRecords(), WordDbModel::getId);
        return MybatisPlusUtils.batchMapping(pageModels, dbModels -> WordDbCovert.toAggrs(dbModels));
    }
}
