package ${package};
import com.google.common.collect.Lists;
import github.shiyajian.${rootArtifactId}.domain.model.entity.account.AccountEntity;
import github.shiyajian.${rootArtifactId}.domain.model.entity.account.AccountLoginLogEntity;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.session.SessionInformation;
import org.springframework.security.core.session.SessionRegistry;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Component;
import org.springframework.util.CollectionUtils;

import java.util.Collection;
import java.util.List;
import java.util.stream.Collectors;

/**
 * @author shiyajian
 * create: 2023-01-16
 */
@Component
@Slf4j
public class AccountDomainService {

    @Autowired
    private PasswordEncoder passwordEncoder;

    @Autowired
    private SessionRegistry sessionRegistry;

    public void checkUserName(String accountName) {
        // 校验名称是否包含非法字符
        // 校验名称是否使用邮箱
        // 校验……
    }

    public void checkPassword(AccountEntity account) {
        // 校验密码长度
        // 校验密码是否强密码
        // 校验密码是否合法
        // ……
    }

    public void encodePassword(AccountEntity account) {
        account.setPassword(passwordEncoder.encode(account.getPassword()));
    }

    private List<SessionInformation> getSessionsByAccountName(String userName) {
        List<Object> allPrincipals = sessionRegistry.getAllPrincipals();
        if (CollectionUtils.isEmpty(allPrincipals)) {
            log.info("当前的用户信息为空");
            return Lists.newArrayList();
        }
        List<AccountEntity> userPrincipals = allPrincipals.stream()
                .map(e -> (AccountEntity) e)
                .filter(e -> e.getAccountName().equals(userName))
                .collect(Collectors.toList());

        if (CollectionUtils.isEmpty(userPrincipals)) {
            log.info("没有找到用户：{}对应的登录信息", userName);
            return Lists.newArrayList();
        }

        return userPrincipals.stream()
                .map(e -> sessionRegistry.getAllSessions(userName, false))
                .flatMap(Collection::stream)
                .collect(Collectors.toList());
    }

    public void offlineByAccountName(String accountName) {
        List<SessionInformation> userSessions = this.getSessionsByAccountName(accountName);
        if (CollectionUtils.isEmpty(userSessions)) {
            log.info("没有找到用户session信息");
            return;
        }
        userSessions.forEach(e -> {
            e.expireNow();
            log.info("用户：{}已注销成功", e.getSessionId());
        });
    }

    public void genDefaultPassword(AccountEntity account) {
        account.setPassword("123456");
    }

    public AccountLoginLogEntity genLoginSuccessLog() {
        return null;
    }

    public AccountLoginLogEntity genLoginFailedLog() {
        return null;
    }

    public Boolean needSms(AccountEntity principal) {
        return null;
    }

    public Boolean needCode(AccountEntity principal) {
        return null;
    }

    public void loginFail(AccountEntity principal) {
        // principal.setErrorCount(principal.getErrorCount() + 1);
        // if (spiConfigManager.customOrDefault(null, AccountConfigs.class, AccountConfigs::getLockedSeconds) > 10) {
        //     LocalDateTime lockedStartTime = LocalDateTime.now();
        //     principal.setStatus(AccountStatusEnums.TEMP_LOCKED);
        //     principal.setLockedStartTime(lockedStartTime);
        //     // 锁定12小时
        //     principal.setLockedEndTime(lockedStartTime.plusSeconds(spiConfigManager.customOrDefault(null, AccountConfigs.class, AccountConfigs::getLockedSeconds)));
        // }
    }
}
