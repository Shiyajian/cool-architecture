package com.github.shiyajian.order.facade.endpoint.server.hello.covert;

import com.github.shiyajian.order.domain.model.aggr.HelloAggr;
import com.github.shiyajian.order.domain.model.query.HelloAggrQuery;
import com.github.shiyajian.order.facade.endpoint.server.hello.request.HelloPageServerFacadeRequest;
import com.github.shiyajian.order.facade.endpoint.server.hello.response.HelloDetailServerFacadeResponse;
import com.github.shiyajian.order.facade.endpoint.server.hello.response.HelloPageServerFacadeResponse;

public class HelloServerFacadeCovert {

    public static HelloAggrQuery toQuery(HelloPageServerFacadeRequest request) {
        HelloAggrQuery query = new HelloAggrQuery();
        return query;
    }

    public static HelloPageServerFacadeResponse ofPage(HelloAggr aggr) {
        if (aggr == null) {
            return null;
        }
        HelloPageServerFacadeResponse response = new HelloPageServerFacadeResponse();
        return response;
    }

    public static HelloDetailServerFacadeResponse of(HelloAggr aggr) {
        if (aggr == null) {
            return null;
        }
        HelloDetailServerFacadeResponse response = new HelloDetailServerFacadeResponse();
        return response;
    }
}
