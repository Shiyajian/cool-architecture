package com.github.shiyajian.order.api.feign.world.request;

import com.github.shiyajian.support.api.feign.model.FeignRequest;
import lombok.Data;

@Data
public class WorldDetailFeignApiRequest extends FeignRequest {

    private Long id;
}
