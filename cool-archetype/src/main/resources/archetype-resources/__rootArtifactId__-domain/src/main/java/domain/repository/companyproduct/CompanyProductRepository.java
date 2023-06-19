package ${package};
import github.shiyajian.${rootArtifactId}.domain.model.aggr.CompanyProductAggr;
import github.shiyajian.${rootArtifactId}.domain.model.query.CompanyProductQuery;
import github.shiyajian.${rootArtifactId}.domain.model.entity.CompanyProductEntity;
import java.util.List;
import com.github.shiyajian.support.common.model.page.PageData;

public interface CompanyProductRepository {

    CompanyProductAggr findOne(Long id);

    CompanyProductAggr findOne(Long id, CompanyProductQuery.Options options);

    List<CompanyProductAggr> findList(List<Long> ids);

    List<CompanyProductAggr> findList(List<Long> ids, CompanyProductQuery.Options options);

    PageData<CompanyProductAggr> findPage(CompanyProductQuery query);
}
