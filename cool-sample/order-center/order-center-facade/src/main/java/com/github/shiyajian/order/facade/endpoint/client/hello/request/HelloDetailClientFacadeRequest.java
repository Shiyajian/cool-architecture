package com.github.shiyajian.order.facade.endpoint.client.hello.request;

import com.github.shiyajian.cool.support.facade.endpoint.model.BaseRequest;
import lombok.Data;

@Data
public class HelloDetailClientFacadeRequest extends BaseRequest {

    private Long id;
}
