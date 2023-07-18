package com.github.shiyajian.order.test.facade.client;

import com.github.shiyajian.order.facade.endpoint.client.hello.HelloClientFacade;
import com.github.shiyajian.order.facade.endpoint.server.hello.HelloServerFacade;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

/**
 * @author shiyajian
 * create: 2023-06-20
 */
@SpringBootTest
public class HelloClientFacadeTest {

    @Autowired
    private HelloClientFacade helloClientFacade;

    @Test
    public void testFacade() {

    }
}
