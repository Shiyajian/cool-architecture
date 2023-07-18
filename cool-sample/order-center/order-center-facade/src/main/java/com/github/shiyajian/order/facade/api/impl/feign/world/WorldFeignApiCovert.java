package com.github.shiyajian.order.facade.api.impl.feign.world;

import com.github.shiyajian.order.api.feign.world.request.WorldPageFeignApiRequest;
import com.github.shiyajian.order.api.feign.world.response.WorldDetailFeignApiResponse;
import com.github.shiyajian.order.api.feign.world.response.WorldPageFeignApiResponse;
import com.github.shiyajian.order.domain.model.aggr.WorldAggr;
import com.github.shiyajian.order.domain.model.query.WorldAggrQuery;

public class WorldFeignApiCovert {

    public static WorldAggrQuery toQuery(WorldPageFeignApiRequest request) {
        WorldAggrQuery query = new WorldAggrQuery();
        return query;
    }

    public static WorldPageFeignApiResponse ofPage(WorldAggr aggr) {
        if (aggr == null) {
            return null;
        }
        WorldPageFeignApiResponse response = new WorldPageFeignApiResponse();
        return response;
    }

    public static WorldDetailFeignApiResponse of(WorldAggr aggr) {
        if (aggr == null) {
            return null;
        }
        WorldDetailFeignApiResponse response = new WorldDetailFeignApiResponse();
        return response;
    }
}
