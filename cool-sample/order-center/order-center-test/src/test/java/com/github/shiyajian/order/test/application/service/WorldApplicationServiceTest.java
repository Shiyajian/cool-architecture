package com.github.shiyajian.order.test.application.service;

import com.github.shiyajian.order.application.service.WorldApplicationService;
import com.github.shiyajian.order.domain.model.aggr.WorldAggr;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

/**
 * @author shiyajian
 * create: 2023-07-21
 */
@SpringBootTest
public class WorldApplicationServiceTest {

    @Autowired
    private WorldApplicationService worldApplicationService;

    @Test
    public void test_update() {
        WorldAggr worldAggr = new WorldAggr();
        worldApplicationService.update(worldAggr);
    }
}
