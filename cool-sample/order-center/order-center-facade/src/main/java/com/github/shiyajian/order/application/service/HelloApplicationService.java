package com.github.shiyajian.order.application.service;

import com.github.shiyajian.order.domain.model.aggr.HelloAggr;

/**
 * @author shiyajian
 * create: 2023-07-21
 */
public interface HelloApplicationService {

    HelloAggr create(HelloAggr helloAggr);
}
