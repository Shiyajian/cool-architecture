package ${package};
import lombok.Data;

import java.time.LocalDateTime;

/**
 * @author shiyajian
 * create: 2023-01-16
 */
@Data
public class AccountLoginLogEntity {

    private Long accountId;

    private LocalDateTime lastLoginTime;

    private LocalDateTime lastLoginIp;
}
