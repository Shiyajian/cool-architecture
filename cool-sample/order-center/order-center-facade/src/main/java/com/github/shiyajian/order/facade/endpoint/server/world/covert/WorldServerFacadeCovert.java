package com.github.shiyajian.order.facade.endpoint.server.world.covert;

import com.github.shiyajian.order.domain.model.aggr.WorldAggr;
import com.github.shiyajian.order.domain.model.query.WorldAggrQuery;
import com.github.shiyajian.order.facade.endpoint.server.world.request.WorldPageServerFacadeRequest;
import com.github.shiyajian.order.facade.endpoint.server.world.response.WorldDetailServerFacadeResponse;
import com.github.shiyajian.order.facade.endpoint.server.world.response.WorldPageServerFacadeResponse;

public class WorldServerFacadeCovert {

    public static WorldAggrQuery toQuery(WorldPageServerFacadeRequest request) {
        WorldAggrQuery query = new WorldAggrQuery();
        return query;
    }

    public static WorldPageServerFacadeResponse ofPage(WorldAggr aggr) {
        if (aggr == null) {
            return null;
        }
        WorldPageServerFacadeResponse response = new WorldPageServerFacadeResponse();
        return response;
    }

    public static WorldDetailServerFacadeResponse of(WorldAggr aggr) {
        if (aggr == null) {
            return null;
        }
        WorldDetailServerFacadeResponse response = new WorldDetailServerFacadeResponse();
        return response;
    }
}
