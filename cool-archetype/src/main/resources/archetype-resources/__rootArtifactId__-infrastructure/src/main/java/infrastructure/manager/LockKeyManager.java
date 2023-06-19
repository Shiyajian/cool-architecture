package ${package};
import org.springframework.stereotype.Component;

/**
 * Redis 的 key 全部放这里
 * @author shiyajian
 * create: 2022-12-30
 */
@Component
public class LockKeyManager {
    public static final String ACCOUNT_NAME_LOCK_KEY = "shiyajian:acc:name:lock";
}
