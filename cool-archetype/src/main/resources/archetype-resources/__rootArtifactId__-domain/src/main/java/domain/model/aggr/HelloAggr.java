package ${package};
import lombok.Data;
import github.shiyajian.${rootArtifactId}.domain.model.entity.TestEntity;

@Data
public class HelloAggr {

    private HelloEntity root;

    private List<WorldEntity> worlds;
}
