package com.github.shiyajian.order.facade.endpoint.client.hello;

import com.github.shiyajian.cool.support.common.model.PageData;
import com.github.shiyajian.order.domain.model.aggr.HelloAggr;
import com.github.shiyajian.order.domain.model.query.HelloAggrQuery;
import com.github.shiyajian.order.domain.repository.HelloRepository;
import com.github.shiyajian.order.facade.endpoint.client.hello.covert.HelloClientFacadeCovert;
import com.github.shiyajian.order.facade.endpoint.client.hello.request.HelloDetailClientFacadeRequest;
import com.github.shiyajian.order.facade.endpoint.client.hello.request.HelloPageClientFacadeRequest;
import com.github.shiyajian.order.facade.endpoint.client.hello.response.HelloDetailClientFacadeResponse;
import com.github.shiyajian.order.facade.endpoint.client.hello.response.HelloPageClientFacadeResponse;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@Tag(name = "测试", description = "测试")
public class HelloClientFacade {

    @Autowired
    private HelloRepository helloRepository;

    @GetMapping("/api/client/hello/page")
    @Operation(tags = "分页查询列表")
    public PageData<HelloPageClientFacadeResponse> getPage(@Validated HelloPageClientFacadeRequest request) {
        HelloAggrQuery query = HelloClientFacadeCovert.toQuery(request);
        PageData<HelloAggr> pageResult = helloRepository.findPage(query);
        return pageResult.mapping(HelloClientFacadeCovert::ofPage);
    }

    @GetMapping("/api/client/hello/detail")
    @Operation(tags = "查询详情")
    public HelloDetailClientFacadeResponse getDetail(@Validated HelloDetailClientFacadeRequest request) {
        HelloAggrQuery.Options options = new HelloAggrQuery.Options();
        options.setWithWorld(true);
        HelloAggr aggr = helloRepository.findOne(request.getId(), options);
        return HelloClientFacadeCovert.of(aggr);
    }
}
