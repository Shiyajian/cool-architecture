package com.github.shiyajian.cool.support.infrastructure.cache;

/**
 * @author shiyajian
 * create: 2023-03-24
 */
public interface Cacheable {

    String cacheKeyExp();

    default long storeTime() {
        return 2000L;
    }

    Class<?> valueClazz();

}
