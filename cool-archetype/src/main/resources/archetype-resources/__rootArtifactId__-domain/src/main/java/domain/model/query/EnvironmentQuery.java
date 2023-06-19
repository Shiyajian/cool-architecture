package ${package};
import com.github.shiyajian.support.common.model.page.Pager;
import lombok.Data;

import java.util.List;

@Data
public class EnvironmentQuery extends Pager {

    private List<Long> ids;

    private Options options;

    public EnvironmentQuery() {
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
