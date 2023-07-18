package com.github.shiyajian.order.facade.api.impl.dubbo.world;

import com.github.shiyajian.cool.support.common.model.PageData;
import com.github.shiyajian.order.api.dubbo.world.WorldDubboApi;
import com.github.shiyajian.order.api.dubbo.world.request.WorldDetailDubboApiRequest;
import com.github.shiyajian.order.api.dubbo.world.request.WorldPageDubboApiRequest;
import com.github.shiyajian.order.api.dubbo.world.response.WorldDetailDubboApiResponse;
import com.github.shiyajian.order.api.dubbo.world.response.WorldPageDubboApiResponse;
import com.github.shiyajian.order.domain.model.aggr.WorldAggr;
import com.github.shiyajian.order.domain.model.query.WorldAggrQuery;
import com.github.shiyajian.order.domain.repository.WorldRepository;
import com.github.shiyajian.support.api.common.model.ApiResult;
import com.github.shiyajian.cool.support.infrastructure.rpc.RpcTemplate;
import org.apache.dubbo.config.annotation.DubboService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.validation.annotation.Validated;

@Service
@DubboService
public class WorldDubboApiImpl implements WorldDubboApi {

    @Autowired
    private WorldRepository helloRepository;

    public ApiResult<PageData<WorldPageDubboApiResponse>> getPage(@Validated WorldPageDubboApiRequest request) {
        return RpcTemplate.execute(() -> {
            WorldAggrQuery query = WorldDubboApiCovert.toQuery(request);
            PageData<WorldAggr> pageResult = helloRepository.findPage(query);
            return pageResult.mapping(WorldDubboApiCovert::ofPage);
        });
    }

    public ApiResult<WorldDetailDubboApiResponse> getDetail(@Validated WorldDetailDubboApiRequest request) {
        return RpcTemplate.execute(() -> {
            WorldAggrQuery.Options options = new WorldAggrQuery.Options();
            options.setWithWorld(true);
            WorldAggr aggr = helloRepository.findOne(request.getId(), options);
            return WorldDubboApiCovert.of(aggr);
        });
    }
}
