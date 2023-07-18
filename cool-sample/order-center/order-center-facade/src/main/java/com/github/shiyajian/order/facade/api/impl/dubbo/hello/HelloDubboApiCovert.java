package com.github.shiyajian.order.facade.api.impl.dubbo.hello;

import com.github.shiyajian.order.domain.model.aggr.HelloAggr;
import com.github.shiyajian.order.domain.model.query.HelloAggrQuery;
import com.github.shiyajian.order.api.dubbo.hello.request.HelloPageDubboApiRequest;
import com.github.shiyajian.order.api.dubbo.hello.response.HelloDetailDubboApiResponse;
import com.github.shiyajian.order.api.dubbo.hello.response.HelloPageDubboApiResponse;

public class HelloDubboApiCovert {

    public static HelloAggrQuery toQuery(HelloPageDubboApiRequest request) {
        HelloAggrQuery query = new HelloAggrQuery();
        return query;
    }

    public static HelloPageDubboApiResponse ofPage(HelloAggr aggr) {
        if (aggr == null) {
            return null;
        }
        HelloPageDubboApiResponse response = new HelloPageDubboApiResponse();
        return response;
    }

    public static HelloDetailDubboApiResponse of(HelloAggr aggr) {
        if (aggr == null) {
            return null;
        }
        HelloDetailDubboApiResponse response = new HelloDetailDubboApiResponse();
        return response;
    }
}
