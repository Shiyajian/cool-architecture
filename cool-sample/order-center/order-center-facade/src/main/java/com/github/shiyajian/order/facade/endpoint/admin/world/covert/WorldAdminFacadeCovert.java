package com.github.shiyajian.order.facade.endpoint.admin.world.covert;

import com.github.shiyajian.order.domain.model.aggr.WorldAggr;
import com.github.shiyajian.order.domain.model.query.WorldAggrQuery;
import com.github.shiyajian.order.facade.endpoint.admin.world.request.WorldPageAdminFacadeRequest;
import com.github.shiyajian.order.facade.endpoint.admin.world.response.WorldDetailAdminFacadeResponse;
import com.github.shiyajian.order.facade.endpoint.admin.world.response.WorldPageAdminFacadeResponse;

public class WorldAdminFacadeCovert {

    public static WorldAggrQuery toQuery(WorldPageAdminFacadeRequest request) {
        WorldAggrQuery query = new WorldAggrQuery();
        return query;
    }

    public static WorldPageAdminFacadeResponse ofPage(WorldAggr aggr) {
        if (aggr == null) {
            return null;
        }
        WorldPageAdminFacadeResponse response = new WorldPageAdminFacadeResponse();
        return response;
    }

    public static WorldDetailAdminFacadeResponse of(WorldAggr aggr) {
        if (aggr == null) {
            return null;
        }
        WorldDetailAdminFacadeResponse response = new WorldDetailAdminFacadeResponse();
        return response;
    }
}
