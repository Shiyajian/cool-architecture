package com.github.shiyajian.cool.support.infrastructure.lock;

import com.github.shiyajian.cool.support.infrastructure.spring.SpringUtil;
import org.redisson.api.RLock;
import org.redisson.api.RedissonClient;

import java.util.function.Supplier;

/**
 * @author shiyajian
 * create: 2023-06-10
 */
public class LockTemplate {

    private LockTemplate() { /* no instance */ }

    public static void run(Lockable lockable, Runnable runnable, Object... args) {
        String lockKey = lockable.lockKeyExp();
        if (args.length > 0) {
            lockKey = String.format(lockKey, args);
        }
        RLock lock = SpringUtil.getBean(RedissonClient.class).getLock(lockKey);
        boolean hasLock = lock.tryLock();
        if (hasLock) {
            try {
                runnable.run();
            } finally {
                lock.unlock();
            }
        }
    }

    public static <T> T call(Lockable lockable, Supplier<T> supplier, Object... args) {
        String lockKey = lockable.lockKeyExp();
        if (args.length > 0) {
            lockKey = String.format(lockKey, args);
        }
        RLock lock = SpringUtil.getBean(RedissonClient.class).getLock(lockKey);
        boolean hasLock = lock.tryLock();
        if (hasLock) {
            try {
                return supplier.get();
            } finally {
                lock.unlock();
            }
        }
        throw new RuntimeException("获取锁失败");
    }
}
