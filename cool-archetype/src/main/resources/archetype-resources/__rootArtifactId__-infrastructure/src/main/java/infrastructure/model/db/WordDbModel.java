package ${package};
import lombok.Data;
import com.baomidou.mybatisplus.annotation.TableName;

@Data
@TableName("t_word")
public class WordDbModel {

    private Long id;

    private Boolean isDeleted;
}
