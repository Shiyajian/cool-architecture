package ${package};
import lombok.Data;
import com.github.shiyajian.support.facade.endpoint.model.BaseRequest;

@Data
public class WordDetailServerFacadeRequest extends BaseRequest {

    private Long id;
}
