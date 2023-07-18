package com.github.shiyajian.order.facade.endpoint.client.hello.covert;

import com.github.shiyajian.order.domain.model.aggr.HelloAggr;
import com.github.shiyajian.order.domain.model.query.HelloAggrQuery;
import com.github.shiyajian.order.facade.endpoint.client.hello.request.HelloPageClientFacadeRequest;
import com.github.shiyajian.order.facade.endpoint.client.hello.response.HelloDetailClientFacadeResponse;
import com.github.shiyajian.order.facade.endpoint.client.hello.response.HelloPageClientFacadeResponse;

public class HelloClientFacadeCovert {

    public static HelloAggrQuery toQuery(HelloPageClientFacadeRequest request) {
        HelloAggrQuery query = new HelloAggrQuery();
        return query;
    }

    public static HelloPageClientFacadeResponse ofPage(HelloAggr aggr) {
        if (aggr == null) {
            return null;
        }
        HelloPageClientFacadeResponse response = new HelloPageClientFacadeResponse();
        return response;
    }

    public static HelloDetailClientFacadeResponse of(HelloAggr aggr) {
        if (aggr == null) {
            return null;
        }
        HelloDetailClientFacadeResponse response = new HelloDetailClientFacadeResponse();
        return response;
    }
}
