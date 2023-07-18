package com.github.shiyajian.order.api.dubbo.hello.request;

import com.github.shiyajian.support.api.dubbo.model.DubboRequest;
import lombok.Data;

@Data
public class HelloDetailDubboApiRequest extends DubboRequest {

    private Long id;
}
