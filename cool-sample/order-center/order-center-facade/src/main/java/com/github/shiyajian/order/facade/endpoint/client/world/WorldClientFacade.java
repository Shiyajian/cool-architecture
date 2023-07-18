package com.github.shiyajian.order.facade.endpoint.client.world;

import com.github.shiyajian.cool.support.common.model.PageData;
import com.github.shiyajian.order.domain.model.aggr.WorldAggr;
import com.github.shiyajian.order.domain.model.query.WorldAggrQuery;
import com.github.shiyajian.order.domain.repository.WorldRepository;
import com.github.shiyajian.order.facade.endpoint.client.world.covert.WorldClientFacadeCovert;
import com.github.shiyajian.order.facade.endpoint.client.world.request.WorldDetailClientFacadeRequest;
import com.github.shiyajian.order.facade.endpoint.client.world.request.WorldPageClientFacadeRequest;
import com.github.shiyajian.order.facade.endpoint.client.world.response.WorldDetailClientFacadeResponse;
import com.github.shiyajian.order.facade.endpoint.client.world.response.WorldPageClientFacadeResponse;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@Tag(name = "测试", description = "测试")
public class WorldClientFacade {

    @Autowired
    private WorldRepository worldRepository;

    @GetMapping("/api/client/world/page")
    @Operation(tags = "分页查询列表")
    public PageData<WorldPageClientFacadeResponse> getPage(@Validated WorldPageClientFacadeRequest request) {
        WorldAggrQuery query = WorldClientFacadeCovert.toQuery(request);
        PageData<WorldAggr> pageResult = worldRepository.findPage(query);
        return pageResult.mapping(WorldClientFacadeCovert::ofPage);
    }

    @GetMapping("/api/client/world/detail")
    @Operation(tags = "查询详情")
    public WorldDetailClientFacadeResponse getDetail(@Validated WorldDetailClientFacadeRequest request) {
        WorldAggrQuery.Options options = new WorldAggrQuery.Options();
        options.setWithWorld(true);
        WorldAggr aggr = worldRepository.findOne(request.getId(), options);
        return WorldClientFacadeCovert.of(aggr);
    }
}
