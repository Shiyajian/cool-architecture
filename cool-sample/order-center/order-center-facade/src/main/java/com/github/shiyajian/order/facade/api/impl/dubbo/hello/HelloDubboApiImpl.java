package com.github.shiyajian.order.facade.api.impl.dubbo.hello;

import com.github.shiyajian.cool.support.common.model.PageData;
import com.github.shiyajian.order.api.dubbo.hello.HelloDubboApi;
import com.github.shiyajian.order.api.dubbo.hello.request.HelloDetailDubboApiRequest;
import com.github.shiyajian.order.api.dubbo.hello.request.HelloPageDubboApiRequest;
import com.github.shiyajian.order.api.dubbo.hello.response.HelloDetailDubboApiResponse;
import com.github.shiyajian.order.api.dubbo.hello.response.HelloPageDubboApiResponse;
import com.github.shiyajian.order.domain.model.aggr.HelloAggr;
import com.github.shiyajian.order.domain.model.query.HelloAggrQuery;
import com.github.shiyajian.order.domain.repository.HelloRepository;
import com.github.shiyajian.support.api.common.model.ApiResult;
import com.github.shiyajian.cool.support.infrastructure.rpc.RpcTemplate;
import org.apache.dubbo.config.annotation.DubboService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.validation.annotation.Validated;

@Service
@DubboService
public class HelloDubboApiImpl implements HelloDubboApi {

    @Autowired
    private HelloRepository helloRepository;

    public ApiResult<PageData<HelloPageDubboApiResponse>> getPage(@Validated HelloPageDubboApiRequest request) {
        return RpcTemplate.execute(() -> {
            HelloAggrQuery query = HelloDubboApiCovert.toQuery(request);
            PageData<HelloAggr> pageResult = helloRepository.findPage(query);
            return pageResult.mapping(HelloDubboApiCovert::ofPage);
        });
    }

    public ApiResult<HelloDetailDubboApiResponse> getDetail(@Validated HelloDetailDubboApiRequest request) {
        return RpcTemplate.execute(() -> {
            HelloAggrQuery.Options options = new HelloAggrQuery.Options();
            options.setWithWorld(true);
            HelloAggr aggr = helloRepository.findOne(request.getId(), options);
            return HelloDubboApiCovert.of(aggr);
        });
    }
}
