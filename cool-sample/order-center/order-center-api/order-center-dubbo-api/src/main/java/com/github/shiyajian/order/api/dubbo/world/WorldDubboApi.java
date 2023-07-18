package com.github.shiyajian.order.api.dubbo.world;

import com.github.shiyajian.cool.support.common.model.PageData;
import com.github.shiyajian.order.api.dubbo.world.request.WorldDetailDubboApiRequest;
import com.github.shiyajian.order.api.dubbo.world.request.WorldPageDubboApiRequest;
import com.github.shiyajian.order.api.dubbo.world.response.WorldDetailDubboApiResponse;
import com.github.shiyajian.order.api.dubbo.world.response.WorldPageDubboApiResponse;
import com.github.shiyajian.support.api.common.model.ApiResult;

/**
 * @author shiyajian
 * create: 2023-05-09
 */
public interface WorldDubboApi {

    ApiResult<PageData<WorldPageDubboApiResponse>> getPage(WorldPageDubboApiRequest request);

    ApiResult<WorldDetailDubboApiResponse> getDetail(WorldDetailDubboApiRequest request);
}
