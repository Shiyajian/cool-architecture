package ${package};
import com.github.shiyajian.support.common.model.page.PageData;
import github.shiyajian.${rootArtifactId}.domain.model.entity.project.ApplicationEntity;
import github.shiyajian.${rootArtifactId}.domain.model.query.ApplicationPageQuery;

/**
 * @author shiyajian
 * create: 2022-07-25
 */
public interface ApplicationRepository {

    void saveApplication(ApplicationEntity applicationEntity);

    PageData<ApplicationEntity> page(ApplicationPageQuery query);
}
