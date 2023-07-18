package com.github.shiyajian.order.api.feign.hello.request;

import com.github.shiyajian.support.api.feign.model.FeignRequest;
import lombok.Data;

@Data
public class HelloDetailFeignApiRequest extends FeignRequest {

    private Long id;
}
