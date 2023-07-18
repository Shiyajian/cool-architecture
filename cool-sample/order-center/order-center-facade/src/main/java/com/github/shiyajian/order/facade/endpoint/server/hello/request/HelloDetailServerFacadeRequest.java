package com.github.shiyajian.order.facade.endpoint.server.hello.request;

import com.github.shiyajian.cool.support.facade.endpoint.model.BaseRequest;
import lombok.Data;

@Data
public class HelloDetailServerFacadeRequest extends BaseRequest {

    private Long id;
}
