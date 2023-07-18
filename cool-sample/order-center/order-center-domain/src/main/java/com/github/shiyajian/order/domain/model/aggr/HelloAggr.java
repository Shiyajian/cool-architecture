package com.github.shiyajian.order.domain.model.aggr;

import com.github.shiyajian.order.domain.model.entity.Hello;
import com.github.shiyajian.order.domain.model.entity.World;
import lombok.Data;

import java.util.List;

@Data
public class HelloAggr {

    private Hello root;

    private List<World> worlds;
}
