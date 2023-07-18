package com.github.shiyajian.order.facade.endpoint.admin.world;

import com.github.shiyajian.cool.support.common.model.PageData;
import com.github.shiyajian.order.domain.model.aggr.WorldAggr;
import com.github.shiyajian.order.domain.model.query.WorldAggrQuery;
import com.github.shiyajian.order.domain.repository.WorldRepository;
import com.github.shiyajian.order.facade.endpoint.admin.world.covert.WorldAdminFacadeCovert;
import com.github.shiyajian.order.facade.endpoint.admin.world.request.WorldDetailAdminFacadeRequest;
import com.github.shiyajian.order.facade.endpoint.admin.world.request.WorldPageAdminFacadeRequest;
import com.github.shiyajian.order.facade.endpoint.admin.world.response.WorldDetailAdminFacadeResponse;
import com.github.shiyajian.order.facade.endpoint.admin.world.response.WorldPageAdminFacadeResponse;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@Tag(name = "测试", description = "测试")
public class WorldAdminFacade {

    @Autowired
    private WorldRepository worldRepository;

    @GetMapping("/api/admin/world/page")
    @Operation(tags = "分页查询列表")
    public PageData<WorldPageAdminFacadeResponse> getPage(@Validated WorldPageAdminFacadeRequest request) {
        WorldAggrQuery query = WorldAdminFacadeCovert.toQuery(request);
        PageData<WorldAggr> pageResult = worldRepository.findPage(query);
        return pageResult.mapping(WorldAdminFacadeCovert::ofPage);
    }

    @GetMapping("/api/admin/world/detail")
    @Operation(tags = "查询详情")
    public WorldDetailAdminFacadeResponse getDetail(@Validated WorldDetailAdminFacadeRequest request) {
        WorldAggrQuery.Options options = new WorldAggrQuery.Options();
        options.setWithWorld(true);
        WorldAggr aggr = worldRepository.findOne(request.getId(), options);
        return WorldAdminFacadeCovert.of(aggr);
    }
}
