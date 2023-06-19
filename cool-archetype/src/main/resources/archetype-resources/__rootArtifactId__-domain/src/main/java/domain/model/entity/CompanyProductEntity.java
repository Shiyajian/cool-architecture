package ${package};
import lombok.Data;

import java.time.LocalDateTime;

@Data
public class CompanyProductEntity {

    private Long id;

    private String tenantId;

    private String productName;

    private String productIcon;

    private String productDesc;

    private LocalDateTime gmtCreated;

    private LocalDateTime gmtUpdated;

    private Long createUid;

    private Long updateUid;

}
