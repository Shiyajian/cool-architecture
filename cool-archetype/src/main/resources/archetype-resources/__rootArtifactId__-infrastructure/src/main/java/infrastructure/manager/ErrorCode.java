package ${package};
import com.github.shiyajian.support.common.exception.IErrorCode;
import lombok.AllArgsConstructor;

/**
 * @author shiyajian
 * create: 2022-09-08
 */
@AllArgsConstructor
public enum ErrorCode implements IErrorCode {

    COMMON_001(20001_0001L, "操作正在进行中，请稍后重试！"),
    ACCOUNT_001(20001_0001L, "账号创建时间，用户名已存在！");

    private Long code;

    private String message;

    @Override
    public Long code() {
        return this.code;
    }

    @Override
    public String message() {
        return this.message;
    }
}
