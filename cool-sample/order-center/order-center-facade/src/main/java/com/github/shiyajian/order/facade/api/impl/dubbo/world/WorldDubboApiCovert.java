package com.github.shiyajian.order.facade.api.impl.dubbo.world;

import com.github.shiyajian.order.api.dubbo.world.request.WorldPageDubboApiRequest;
import com.github.shiyajian.order.api.dubbo.world.response.WorldDetailDubboApiResponse;
import com.github.shiyajian.order.api.dubbo.world.response.WorldPageDubboApiResponse;
import com.github.shiyajian.order.domain.model.aggr.WorldAggr;
import com.github.shiyajian.order.domain.model.query.WorldAggrQuery;

public class WorldDubboApiCovert {

    public static WorldAggrQuery toQuery(WorldPageDubboApiRequest request) {
        WorldAggrQuery query = new WorldAggrQuery();
        return query;
    }

    public static WorldPageDubboApiResponse ofPage(WorldAggr aggr) {
        if (aggr == null) {
            return null;
        }
        WorldPageDubboApiResponse response = new WorldPageDubboApiResponse();
        return response;
    }

    public static WorldDetailDubboApiResponse of(WorldAggr aggr) {
        if (aggr == null) {
            return null;
        }
        WorldDetailDubboApiResponse response = new WorldDetailDubboApiResponse();
        return response;
    }
}
