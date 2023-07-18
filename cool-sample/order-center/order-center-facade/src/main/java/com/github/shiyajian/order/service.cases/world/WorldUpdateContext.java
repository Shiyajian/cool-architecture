package com.github.shiyajian.order.service.cases.world;

import com.github.shiyajian.cool.support.services.cases.Context;
import com.github.shiyajian.order.domain.model.aggr.WorldAggr;
import com.github.shiyajian.order.domain.model.entity.Hello;
import lombok.Data;

import java.util.List;

/**
 * @author shiyajian
 * create: 2023-04-03
 */
@Data
public class WorldUpdateContext extends Context {

    private WorldAggr newWorld;

    private WorldAggr oldWorld;

}
