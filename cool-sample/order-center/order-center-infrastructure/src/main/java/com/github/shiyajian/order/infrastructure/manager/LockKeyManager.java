package com.github.shiyajian.order.infrastructure.manager;

import com.github.shiyajian.cool.support.infrastructure.lock.Lockable;
import lombok.AllArgsConstructor;
import lombok.Getter;

/**
 * Redis 的 key 全部放这里
 *
 * @author shiyajian
 * create: 2022-12-30
 */
@Getter
@AllArgsConstructor
public enum LockKeyManager implements Lockable {

    HELLO_LOCK("c.g.syj.lock.hello.%s", 1, "在xx时候加锁，hello的id维度"),

    ;

    private final String lockKeyExp;

    private final int argLength;

    private final String remark;


    @Override
    public String lockKeyExp() {
        return this.lockKeyExp;
    }

    @Override
    public int argLength() {
        return this.argLength();
    }

    @Override
    public String remark() {
        return this.remark;
    }
}
