package com.github.shiyajian.order.test.facade.server;

import com.github.shiyajian.cool.support.common.model.PageData;
import com.github.shiyajian.order.domain.model.aggr.HelloAggr;
import com.github.shiyajian.order.domain.model.query.HelloAggrQuery;
import com.github.shiyajian.order.domain.repository.HelloRepository;
import com.github.shiyajian.order.facade.endpoint.server.hello.HelloServerFacade;
import org.apache.commons.collections4.CollectionUtils;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

/**
 * @author shiyajian
 * create: 2023-06-20
 */
@SpringBootTest
public class HelloServerFacadeTest {

    @Autowired
    private HelloServerFacade helloServerFacade;

    @Test
    public void testFacade() {

    }
}
