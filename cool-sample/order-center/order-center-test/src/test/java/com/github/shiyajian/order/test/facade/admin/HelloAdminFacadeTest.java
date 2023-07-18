package com.github.shiyajian.order.test.facade.admin;

import com.github.shiyajian.order.facade.endpoint.admin.hello.HelloAdminFacade;
import com.github.shiyajian.order.facade.endpoint.server.hello.HelloServerFacade;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

/**
 * @author shiyajian
 * create: 2023-06-20
 */
@SpringBootTest
public class HelloAdminFacadeTest {

    @Autowired
    private HelloAdminFacade helloAdminFacade;

    @Test
    public void testFacade() {

    }
}
