package com.github.shiyajian.order.infrastructure.manager;

import com.github.shiyajian.cool.support.infrastructure.cache.Cacheable;
import com.github.shiyajian.order.infrastructure.model.cache.HelloCacheModel;
import lombok.AllArgsConstructor;
import lombok.Getter;

/**
 * 缓存中所有key放在这里 的 key 全部放这里
 *
 * @author shiyajian
 * create: 2022-12-30
 */
@Getter
@AllArgsConstructor
public enum CacheKeyManager implements Cacheable {

    HELLO_CACHE("c.g.syj.hello.%s", 4800L, HelloCacheModel.class),

    ;

    private final String cacheKeyExp;

    private final Long storeTime;

    private final Class<?> valueClazz;


    @Override
    public String cacheKeyExp() {
        return this.cacheKeyExp;
    }

    @Override
    public long storeTime() {
        return this.storeTime;
    }

    @Override
    public Class<?> valueClazz() {
        return this.valueClazz;
    }

}
