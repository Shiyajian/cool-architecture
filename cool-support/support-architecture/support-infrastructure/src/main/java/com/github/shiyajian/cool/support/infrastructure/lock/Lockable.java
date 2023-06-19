package com.github.shiyajian.cool.support.infrastructure.lock;

/**
 * @author shiyajian
 * create: 2023-03-24
 */
public interface Lockable {

    String lockKeyExp();

    default long timeoutMills() {
        return -1L;
    }

    String remark();

}
