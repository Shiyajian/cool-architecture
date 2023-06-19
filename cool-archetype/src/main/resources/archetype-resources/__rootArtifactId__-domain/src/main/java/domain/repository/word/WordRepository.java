package ${package};
import github.shiyajian.${rootArtifactId}.domain.model.query.WordQuery;
import github.shiyajian.${rootArtifactId}.domain.model.aggr.WordAggr;
import java.util.List;
import com.github.shiyajian.support.common.model.page.PageData;

public interface WordRepository {

    WordAggr findOne(Long id);

    WordAggr findOne(Long id, WordQuery.Options options);

    List<WordAggr> findList(List<Long> ids);

    List<WordAggr> findList(List<Long> ids, WordQuery.Options options);

    PageData<WordAggr> findPage(WordQuery query);
}
