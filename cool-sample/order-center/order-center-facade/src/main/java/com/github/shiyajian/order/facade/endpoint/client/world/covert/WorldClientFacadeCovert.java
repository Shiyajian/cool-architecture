package com.github.shiyajian.order.facade.endpoint.client.world.covert;

import com.github.shiyajian.order.domain.model.aggr.WorldAggr;
import com.github.shiyajian.order.domain.model.query.WorldAggrQuery;
import com.github.shiyajian.order.facade.endpoint.client.world.request.WorldPageClientFacadeRequest;
import com.github.shiyajian.order.facade.endpoint.client.world.response.WorldDetailClientFacadeResponse;
import com.github.shiyajian.order.facade.endpoint.client.world.response.WorldPageClientFacadeResponse;

public class WorldClientFacadeCovert {

    public static WorldAggrQuery toQuery(WorldPageClientFacadeRequest request) {
        WorldAggrQuery query = new WorldAggrQuery();
        return query;
    }

    public static WorldPageClientFacadeResponse ofPage(WorldAggr aggr) {
        if (aggr == null) {
            return null;
        }
        WorldPageClientFacadeResponse response = new WorldPageClientFacadeResponse();
        return response;
    }

    public static WorldDetailClientFacadeResponse of(WorldAggr aggr) {
        if (aggr == null) {
            return null;
        }
        WorldDetailClientFacadeResponse response = new WorldDetailClientFacadeResponse();
        return response;
    }
}
