package ${package};
import com.github.shiyajian.support.common.model.common.BasePage;
import lombok.Data;

/**
 * @author shiyajian
 * create: 2022-12-30
 */
@Data
public class ApplicationPageQuery extends BasePage {

    private String applicationName;
}
