package com.github.shiyajian.order.facade.endpoint.server.hello;

import com.github.shiyajian.cool.support.common.model.PageData;
import com.github.shiyajian.order.domain.model.aggr.HelloAggr;
import com.github.shiyajian.order.domain.model.query.HelloAggrQuery;
import com.github.shiyajian.order.domain.repository.HelloRepository;
import com.github.shiyajian.order.facade.endpoint.server.hello.covert.HelloServerFacadeCovert;
import com.github.shiyajian.order.facade.endpoint.server.hello.request.HelloDetailServerFacadeRequest;
import com.github.shiyajian.order.facade.endpoint.server.hello.request.HelloPageServerFacadeRequest;
import com.github.shiyajian.order.facade.endpoint.server.hello.response.HelloDetailServerFacadeResponse;
import com.github.shiyajian.order.facade.endpoint.server.hello.response.HelloPageServerFacadeResponse;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@Tag(name = "测试", description = "测试")
public class HelloServerFacade {

    @Autowired
    private HelloRepository helloRepository;

    @GetMapping("/api/server/hello/page")
    @Operation(tags = "分页查询列表")
    public PageData<HelloPageServerFacadeResponse> getPage(@Validated HelloPageServerFacadeRequest request) {
        HelloAggrQuery query = HelloServerFacadeCovert.toQuery(request);
        PageData<HelloAggr> pageResult = helloRepository.findPage(query);
        return pageResult.mapping(HelloServerFacadeCovert::ofPage);
    }

    @GetMapping("/api/server/hello/detail")
    @Operation(tags = "查询详情")
    public HelloDetailServerFacadeResponse getDetail(@Validated HelloDetailServerFacadeRequest request) {
        HelloAggrQuery.Options options = new HelloAggrQuery.Options();
        options.setWithWorld(true);
        HelloAggr aggr = helloRepository.findOne(request.getId(), options);
        return HelloServerFacadeCovert.of(aggr);
    }
}
