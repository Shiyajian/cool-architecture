package com.github.shiyajian.order.test.application.service;

import com.github.shiyajian.order.application.service.HelloApplicationService;
import com.github.shiyajian.order.domain.model.aggr.HelloAggr;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

/**
 * @author shiyajian
 * create: 2023-07-21
 */
@SpringBootTest
public class HelloApplicationServiceTest {

    @Autowired
    private HelloApplicationService helloApplicationService;

    @Test
    public void test_create() {
        HelloAggr helloAggr = new HelloAggr();
        helloApplicationService.create(helloAggr);
    }
}
