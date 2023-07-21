package com.github.shiyajian.order.application.service;

import com.github.shiyajian.order.domain.model.aggr.WorldAggr;

/**
 * @author shiyajian
 * create: 2023-07-21
 */
public interface WorldApplicationService {

    WorldAggr update(WorldAggr world);
}
