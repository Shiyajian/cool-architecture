package ${package};
import com.github.shiyajian.support.common.model.page.PageData;
import github.shiyajian.${rootArtifactId}.domain.model.entity.account.AccountEntity;
import github.shiyajian.${rootArtifactId}.domain.model.entity.account.AccountLoginLogEntity;
import github.shiyajian.${rootArtifactId}.domain.model.query.account.AccountPageQuery;

/**
 * @author shiyajian
 * create: 2023-01-04
 */
public interface AccountRepository {
    void update(AccountEntity principal);

    boolean isNameExists(String accountName);

    void create(AccountEntity account);

    void saveLog(AccountLoginLogEntity log);

    PageData<AccountEntity> page( AccountPageQuery query);
}
