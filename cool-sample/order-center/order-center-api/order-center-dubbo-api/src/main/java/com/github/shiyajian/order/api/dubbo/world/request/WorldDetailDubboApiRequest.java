package com.github.shiyajian.order.api.dubbo.world.request;

import com.github.shiyajian.support.api.dubbo.model.DubboRequest;
import lombok.Data;

@Data
public class WorldDetailDubboApiRequest extends DubboRequest {

    private Long id;
}
