package ${package};
import lombok.Data;
import org.springframework.security.core.GrantedAuthority;

/**
 * @author shiyajian
 * create: 2023-01-16
 */
@Data
public class AccountAuthEntity implements GrantedAuthority {

    private String authCode;

    @Override
    public String getAuthority() {
        return this.getAuthCode();
    }
}
