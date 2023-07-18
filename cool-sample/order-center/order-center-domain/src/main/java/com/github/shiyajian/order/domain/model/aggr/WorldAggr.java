package com.github.shiyajian.order.domain.model.aggr;

import com.github.shiyajian.order.domain.model.entity.Hello;
import com.github.shiyajian.order.domain.model.entity.World;
import lombok.Data;

@Data
public class WorldAggr {

    private World root;

    private Hello refHello;
}
