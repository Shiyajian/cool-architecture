package com.github.shiyajian.order.facade.api.impl.feign.hello;

import com.github.shiyajian.cool.support.common.model.PageData;
import com.github.shiyajian.cool.support.infrastructure.rpc.RpcTemplate;
import com.github.shiyajian.order.api.feign.hello.HelloFeignApi;
import com.github.shiyajian.order.api.feign.hello.request.HelloDetailFeignApiRequest;
import com.github.shiyajian.order.api.feign.hello.request.HelloPageFeignApiRequest;
import com.github.shiyajian.order.api.feign.hello.response.HelloDetailFeignApiResponse;
import com.github.shiyajian.order.api.feign.hello.response.HelloPageFeignApiResponse;
import com.github.shiyajian.order.domain.model.aggr.HelloAggr;
import com.github.shiyajian.order.domain.model.query.HelloAggrQuery;
import com.github.shiyajian.order.domain.repository.HelloRepository;
import com.github.shiyajian.support.api.common.model.ApiResult;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.RestController;


@RestController
public class HelloFeignApiImpl implements HelloFeignApi {

    @Autowired
    private HelloRepository helloRepository;

    public ApiResult<PageData<HelloPageFeignApiResponse>> getPage(@Validated HelloPageFeignApiRequest request) {
        return RpcTemplate.execute(() -> {
            HelloAggrQuery query = HelloFeignApiCovert.toQuery(request);
            PageData<HelloAggr> pageResult = helloRepository.findPage(query);
            return pageResult.mapping(HelloFeignApiCovert::ofPage);
        });
    }

    public ApiResult<HelloDetailFeignApiResponse> getDetail(@Validated HelloDetailFeignApiRequest request) {
        return RpcTemplate.execute(() -> {
            HelloAggrQuery.Options options = new HelloAggrQuery.Options();
            options.setWithWorld(true);
            HelloAggr aggr = helloRepository.findOne(request.getId(), options);
            return HelloFeignApiCovert.of(aggr);
        });
    }
}
