package com.github.shiyajian.order.facade.endpoint.admin.hello;

import com.github.shiyajian.cool.support.common.model.PageData;
import com.github.shiyajian.order.domain.model.aggr.HelloAggr;
import com.github.shiyajian.order.domain.model.query.HelloAggrQuery;
import com.github.shiyajian.order.domain.repository.HelloRepository;
import com.github.shiyajian.order.facade.endpoint.admin.hello.covert.HelloAdminFacadeCovert;
import com.github.shiyajian.order.facade.endpoint.admin.hello.request.HelloDetailAdminFacadeRequest;
import com.github.shiyajian.order.facade.endpoint.admin.hello.request.HelloPageAdminFacadeRequest;
import com.github.shiyajian.order.facade.endpoint.admin.hello.response.HelloDetailAdminFacadeResponse;
import com.github.shiyajian.order.facade.endpoint.admin.hello.response.HelloPageAdminFacadeResponse;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@Tag(name = "测试", description = "测试")
public class HelloAdminFacade {

    @Autowired
    private HelloRepository helloRepository;

    @GetMapping("/api/admin/hello/page")
    @Operation(tags = "分页查询列表")
    public PageData<HelloPageAdminFacadeResponse> getPage(@Validated HelloPageAdminFacadeRequest request) {
        HelloAggrQuery query = HelloAdminFacadeCovert.toQuery(request);
        PageData<HelloAggr> pageResult = helloRepository.findPage(query);
        return pageResult.mapping(HelloAdminFacadeCovert::ofPage);
    }

    @GetMapping("/api/admin/hello/detail")
    @Operation(tags = "查询详情")
    public HelloDetailAdminFacadeResponse getDetail(@Validated HelloDetailAdminFacadeRequest request) {
        HelloAggrQuery.Options options = new HelloAggrQuery.Options();
        options.setWithWorld(true);
        HelloAggr aggr = helloRepository.findOne(request.getId(), options);
        return HelloAdminFacadeCovert.of(aggr);
    }
}
