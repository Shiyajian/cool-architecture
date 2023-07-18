package com.github.shiyajian.order.facade.endpoint.server.world;

import com.github.shiyajian.cool.support.common.model.PageData;
import com.github.shiyajian.order.domain.model.aggr.WorldAggr;
import com.github.shiyajian.order.domain.model.query.WorldAggrQuery;
import com.github.shiyajian.order.domain.repository.WorldRepository;
import com.github.shiyajian.order.facade.endpoint.server.world.covert.WorldServerFacadeCovert;
import com.github.shiyajian.order.facade.endpoint.server.world.request.WorldPageServerFacadeRequest;
import com.github.shiyajian.order.facade.endpoint.server.world.response.WorldDetailServerFacadeResponse;
import com.github.shiyajian.order.facade.endpoint.server.world.response.WorldPageServerFacadeResponse;
import com.github.shiyajian.order.facade.endpoint.server.world.request.WorldDetailServerFacadeRequest;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@Tag(name = "测试", description = "测试")
public class WorldServerFacade {

    @Autowired
    private WorldRepository worldRepository;

    @GetMapping("/api/server/world/page")
    @Operation(tags = "分页查询列表")
    public PageData<WorldPageServerFacadeResponse> getPage(@Validated WorldPageServerFacadeRequest request) {
        WorldAggrQuery query = WorldServerFacadeCovert.toQuery(request);
        PageData<WorldAggr> pageResult = worldRepository.findPage(query);
        return pageResult.mapping(WorldServerFacadeCovert::ofPage);
    }

    @GetMapping("/api/server/world/detail")
    @Operation(tags = "查询详情")
    public WorldDetailServerFacadeResponse getDetail(@Validated WorldDetailServerFacadeRequest request) {
        WorldAggrQuery.Options options = new WorldAggrQuery.Options();
        options.setWithWorld(true);
        WorldAggr aggr = worldRepository.findOne(request.getId(), options);
        return WorldServerFacadeCovert.of(aggr);
    }
}
