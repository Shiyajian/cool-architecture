package com.github.shiyajian.order.facade.api.impl.feign.hello;

import com.github.shiyajian.order.api.feign.hello.request.HelloPageFeignApiRequest;
import com.github.shiyajian.order.api.feign.hello.response.HelloDetailFeignApiResponse;
import com.github.shiyajian.order.api.feign.hello.response.HelloPageFeignApiResponse;
import com.github.shiyajian.order.domain.model.aggr.HelloAggr;
import com.github.shiyajian.order.domain.model.query.HelloAggrQuery;

public class HelloFeignApiCovert {

    public static HelloAggrQuery toQuery(HelloPageFeignApiRequest request) {
        HelloAggrQuery query = new HelloAggrQuery();
        return query;
    }

    public static HelloPageFeignApiResponse ofPage(HelloAggr aggr) {
        if (aggr == null) {
            return null;
        }
        HelloPageFeignApiResponse response = new HelloPageFeignApiResponse();
        return response;
    }

    public static HelloDetailFeignApiResponse of(HelloAggr aggr) {
        if (aggr == null) {
            return null;
        }
        HelloDetailFeignApiResponse response = new HelloDetailFeignApiResponse();
        return response;
    }
}
