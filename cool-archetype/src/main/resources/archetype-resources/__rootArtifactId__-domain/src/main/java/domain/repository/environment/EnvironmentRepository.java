package ${package};
import github.shiyajian.${rootArtifactId}.domain.model.query.EnvironmentQuery;
import github.shiyajian.${rootArtifactId}.domain.model.entity.EnvironmentEntity;
import java.util.List;
import com.github.shiyajian.support.common.model.page.PageData;

public interface EnvironmentRepository {

    EnvironmentEntity findOne(Long id);

    EnvironmentEntity findOne(Long id, EnvironmentQuery.Options options);

    List<EnvironmentEntity> findList(List<Long> ids);

    List<EnvironmentEntity> findList(List<Long> ids, EnvironmentQuery.Options options);

    PageData<EnvironmentEntity> findPage(EnvironmentQuery query);
}
