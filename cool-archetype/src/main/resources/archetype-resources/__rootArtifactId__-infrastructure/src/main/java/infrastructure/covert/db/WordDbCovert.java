package ${package};
import java.util.List;
import github.shiyajian.${rootArtifactId}.infrastructure.model.db.WordDbModel;
import github.shiyajian.${rootArtifactId}.domain.model.entity.WordEntity;
import com.github.shiyajian.support.infrastructure.utils.ListHelper;
import org.apache.commons.collections4.CollectionUtils;
import com.google.common.collect.Lists;
import github.shiyajian.${rootArtifactId}.domain.model.aggr.WordAggr;

public class WordDbCovert {

    public static WordEntity toEntity(WordDbModel dbModel) {
        if (dbModel == null) {
            return null;
        }
        WordEntity entity = new WordEntity();
        return entity;
    }

    public static List<WordEntity> toEntities(List<WordDbModel> dbModels) {
        return ListHelper.safeTransform(dbModels, WordDbCovert::toEntity);
    }

    public static List<WordAggr> toAggrs(List<WordDbModel> dbModels) {
        if (CollectionUtils.isEmpty(dbModels)) {
            return Lists.newArrayList();
        }
        return ListHelper.safeTransform(dbModels, dbModel -> {
            WordAggr aggr = new WordAggr();
            aggr.setRoot(toEntity(dbModel));
            return aggr;
        });
    }
}
