package ${package};
import com.google.common.collect.Lists;
import github.shiyajian.${rootArtifactId}.common.enums.account.AccountStatusEnums;
import github.shiyajian.${rootArtifactId}.domain.model.feature.AccountFeature;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.util.CollectionUtils;

import java.time.LocalDateTime;
import java.util.Collection;
import java.util.List;
import java.util.Objects;

/**
 * @author shiyajian
 * create: 2023-01-04
 */
@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class AccountEntity implements UserDetails {

    private Long id;

    private String tenantId;

    private Integer accountType;

    private Long employeeId;

    private String accountName;

    private String password;

    private AccountStatusEnums status;

    private Integer errorCount = 0;

    private Boolean isDeleted;

    private LocalDateTime lockedStartTime;

    private LocalDateTime lockedEndTime;

    private String lockedReason;

    private String lastLoginIp;

    private String lastLoginAddress;

    private String remark;

    private Long createEmployeeId;

    private Long updateEmployeeId;

    private AccountFeature feature;

    private LocalDateTime gmtCreated;

    private LocalDateTime gmtUpdated;

    private List<AccountAuthEntity> auths;

    @Override
    public Collection<? extends GrantedAuthority> getAuthorities() {
        if (CollectionUtils.isEmpty(auths)) {
            return Lists.newArrayList();
        }
        return auths;
    }

    @Override
    public String getPassword() {
        return this.password;
    }

    @Override
    public String getUsername() {
        return this.accountName;
    }

    @Override
    public boolean isAccountNonExpired() {
        return !Objects.equals(this.status, AccountStatusEnums.DISABLED);
    }

    @Override
    public boolean isAccountNonLocked() {
        return !Objects.equals(this.status, AccountStatusEnums.LOCKED) && !Objects.equals(this.status, AccountStatusEnums.TEMP_LOCKED);
    }

    @Override
    public boolean isCredentialsNonExpired() {
        return true;
    }

    @Override
    public boolean isEnabled() {
        return Objects.equals(this.status, AccountStatusEnums.ENABLED);
    }

    public Boolean needSms() {
        return this.errorCount > 5;
    }

    public Boolean needCode() {
        return this.errorCount > 3;
    }
}
