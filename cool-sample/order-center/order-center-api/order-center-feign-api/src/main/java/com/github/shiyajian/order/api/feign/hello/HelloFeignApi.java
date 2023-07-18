package com.github.shiyajian.order.api.feign.hello;


import com.github.shiyajian.cool.support.common.model.PageData;
import com.github.shiyajian.order.api.feign.hello.request.HelloDetailFeignApiRequest;
import com.github.shiyajian.order.api.feign.hello.request.HelloPageFeignApiRequest;
import com.github.shiyajian.order.api.feign.hello.response.HelloDetailFeignApiResponse;
import com.github.shiyajian.order.api.feign.hello.response.HelloPageFeignApiResponse;
import com.github.shiyajian.support.api.common.model.ApiResult;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;

/**
 * @author shiyajian
 * create: 2023-05-09
 */
@FeignClient(name = "hello", contextId = "hello")
public interface HelloFeignApi {

    @GetMapping("/api/feign/hello/page")
    ApiResult<PageData<HelloPageFeignApiResponse>> getPage(HelloPageFeignApiRequest request);

    @GetMapping("/api/feign/hello/detail")
    ApiResult<HelloDetailFeignApiResponse> getDetail(HelloDetailFeignApiRequest request);
}
