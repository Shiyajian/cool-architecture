package com.github.shiyajian.order.api.dubbo.hello;

import com.github.shiyajian.cool.support.common.model.PageData;
import com.github.shiyajian.order.api.dubbo.hello.request.HelloDetailDubboApiRequest;
import com.github.shiyajian.order.api.dubbo.hello.request.HelloPageDubboApiRequest;
import com.github.shiyajian.order.api.dubbo.hello.response.HelloDetailDubboApiResponse;
import com.github.shiyajian.order.api.dubbo.hello.response.HelloPageDubboApiResponse;
import com.github.shiyajian.support.api.common.model.ApiResult;

/**
 * @author shiyajian
 * create: 2023-05-09
 */
public interface HelloDubboApi {

    ApiResult<PageData<HelloPageDubboApiResponse>> getPage(HelloPageDubboApiRequest request);

    ApiResult<HelloDetailDubboApiResponse> getDetail(HelloDetailDubboApiRequest request);
}
