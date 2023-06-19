package ${package};
import github.shiyajian.${rootArtifactId}.domain.model.query.TestQuery;
import github.shiyajian.${rootArtifactId}.domain.model.aggr.TestAggr;
import java.util.List;
import com.github.shiyajian.support.common.model.page.PageData;

public interface TestRepository {

    TestAggr findOne(Long id);

    TestAggr findOne(Long id, TestQuery.Options options);

    List<TestAggr> findList(List<Long> ids);

    List<TestAggr> findList(List<Long> ids, TestQuery.Options options);

    PageData<TestAggr> findPage(TestQuery query);
}
