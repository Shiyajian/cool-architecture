package com.github.shiyajian.order.facade.api.impl.feign.world;

import com.github.shiyajian.cool.support.common.model.PageData;
import com.github.shiyajian.cool.support.infrastructure.rpc.RpcTemplate;
import com.github.shiyajian.order.api.feign.world.WorldFeignApi;
import com.github.shiyajian.order.api.feign.world.request.WorldDetailFeignApiRequest;
import com.github.shiyajian.order.api.feign.world.request.WorldPageFeignApiRequest;
import com.github.shiyajian.order.api.feign.world.response.WorldDetailFeignApiResponse;
import com.github.shiyajian.order.api.feign.world.response.WorldPageFeignApiResponse;
import com.github.shiyajian.order.domain.model.aggr.WorldAggr;
import com.github.shiyajian.order.domain.model.query.WorldAggrQuery;
import com.github.shiyajian.order.domain.repository.WorldRepository;
import com.github.shiyajian.support.api.common.model.ApiResult;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class WorldFeignApiImpl implements WorldFeignApi {

    @Autowired
    private WorldRepository helloRepository;

    public ApiResult<PageData<WorldPageFeignApiResponse>> getPage(@Validated WorldPageFeignApiRequest request) {
        return RpcTemplate.execute(() -> {
            WorldAggrQuery query = WorldFeignApiCovert.toQuery(request);
            PageData<WorldAggr> pageResult = helloRepository.findPage(query);
            return pageResult.mapping(WorldFeignApiCovert::ofPage);
        });
    }

    public ApiResult<WorldDetailFeignApiResponse> getDetail(@Validated WorldDetailFeignApiRequest request) {
        return RpcTemplate.execute(() -> {
            WorldAggrQuery.Options options = new WorldAggrQuery.Options();
            options.setWithWorld(true);
            WorldAggr aggr = helloRepository.findOne(request.getId(), options);
            return WorldFeignApiCovert.of(aggr);
        });
    }
}
