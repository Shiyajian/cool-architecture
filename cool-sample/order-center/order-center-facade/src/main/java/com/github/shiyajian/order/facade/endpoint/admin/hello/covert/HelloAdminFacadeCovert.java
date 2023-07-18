package com.github.shiyajian.order.facade.endpoint.admin.hello.covert;

import com.github.shiyajian.order.domain.model.aggr.HelloAggr;
import com.github.shiyajian.order.domain.model.query.HelloAggrQuery;
import com.github.shiyajian.order.facade.endpoint.admin.hello.request.HelloPageAdminFacadeRequest;
import com.github.shiyajian.order.facade.endpoint.admin.hello.response.HelloDetailAdminFacadeResponse;
import com.github.shiyajian.order.facade.endpoint.admin.hello.response.HelloPageAdminFacadeResponse;

public class HelloAdminFacadeCovert {

    public static HelloAggrQuery toQuery(HelloPageAdminFacadeRequest request) {
        HelloAggrQuery query = new HelloAggrQuery();
        return query;
    }

    public static HelloPageAdminFacadeResponse ofPage(HelloAggr aggr) {
        if (aggr == null) {
            return null;
        }
        HelloPageAdminFacadeResponse response = new HelloPageAdminFacadeResponse();
        return response;
    }

    public static HelloDetailAdminFacadeResponse of(HelloAggr aggr) {
        if (aggr == null) {
            return null;
        }
        HelloDetailAdminFacadeResponse response = new HelloDetailAdminFacadeResponse();
        return response;
    }
}
