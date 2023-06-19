package ${package};
import lombok.Data;
import java.util.List;
import com.github.shiyajian.support.common.model.common.BasePage;

@Data
public class TestQuery extends BasePage {

    private List<Long> ids;

    private Options options;

    public TestQuery() {
        this.options = new Options();
    }

    @Data
    public static class Options {

        private boolean withDeleted;

        public Options() {
            this.withDeleted = false;
        }
    }
}
