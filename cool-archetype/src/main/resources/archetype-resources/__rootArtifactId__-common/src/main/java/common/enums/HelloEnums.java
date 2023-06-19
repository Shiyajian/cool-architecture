package ${package};
import com.github.shiyajian.support.common.enums.BaseEnum;
import lombok.AllArgsConstructor;
import lombok.Getter;

/**
 * 语义上面不能用 Type(类型） 和 状态（Status）所描述的
 * @author shiyajian
 * create: 2023-01-17
 */
@Getter
@AllArgsConstructor
public enum HelloEnums implements BaseEnum {

    WEB(0, "web账号");

    private Integer code;
    private String desc;

    @Override
    public int getCode() {
        return this.code;
    }

    @Override
    public String getDesc() {
        return this.desc;
    }

}
