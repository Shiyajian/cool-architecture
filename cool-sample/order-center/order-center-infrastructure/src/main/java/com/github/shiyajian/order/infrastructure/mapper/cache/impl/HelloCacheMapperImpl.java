package com.github.shiyajian.order.infrastructure.mapper.cache.impl;

import com.github.shiyajian.order.infrastructure.mapper.cache.HelloCacheMapper;
import com.github.shiyajian.order.infrastructure.model.cache.HelloCacheModel;
import com.github.shiyajian.order.infrastructure.model.cache.HelloSimpleCacheModel;
import com.google.common.collect.Lists;
import org.springframework.stereotype.Component;

import java.util.List;

/**
 * @author shiyajian
 * create: 2023-06-20
 */
@Component
public class HelloCacheMapperImpl implements HelloCacheMapper {

//    @Autowired
//    private RedissonClient redissonClient;

    @Override
    public List<HelloCacheModel> getTop5Hello() {
        // 基于redisson 或者 jedis 进行查询
        return Lists.newArrayList();
    }

    @Override
    public HelloSimpleCacheModel getHelloCache(Long id) {
        return null;
    }

}
