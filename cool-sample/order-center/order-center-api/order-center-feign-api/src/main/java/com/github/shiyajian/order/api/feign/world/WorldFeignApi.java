package com.github.shiyajian.order.api.feign.world;

import com.github.shiyajian.cool.support.common.model.PageData;
import com.github.shiyajian.order.api.feign.world.request.WorldDetailFeignApiRequest;
import com.github.shiyajian.order.api.feign.world.request.WorldPageFeignApiRequest;
import com.github.shiyajian.order.api.feign.world.response.WorldDetailFeignApiResponse;
import com.github.shiyajian.order.api.feign.world.response.WorldPageFeignApiResponse;
import com.github.shiyajian.support.api.common.model.ApiResult;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;

/**
 * @author shiyajian
 * create: 2023-05-09
 */
@FeignClient(name = "world", contextId = "world")
public interface WorldFeignApi {

    @GetMapping("/api/feign/world/page")
    ApiResult<PageData<WorldPageFeignApiResponse>> getPage(WorldPageFeignApiRequest request);

    @GetMapping("/api/feign/world/detail")
    ApiResult<WorldDetailFeignApiResponse> getDetail(WorldDetailFeignApiRequest request);
}
