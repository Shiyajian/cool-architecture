package com.github.shiyajian.order.infrastructure.mapper.cache;

import com.github.shiyajian.order.infrastructure.model.cache.HelloCacheModel;
import com.github.shiyajian.order.infrastructure.model.cache.HelloSimpleCacheModel;

import java.util.List;

public interface HelloCacheMapper {

    List<HelloCacheModel> getTop5Hello();

    HelloSimpleCacheModel getHelloCache(Long id);
}
