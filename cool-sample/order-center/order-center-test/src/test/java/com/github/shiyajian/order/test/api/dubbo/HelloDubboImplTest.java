package com.github.shiyajian.order.test.api.dubbo;

import com.github.shiyajian.order.api.dubbo.hello.HelloDubboApi;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

/**
 * @author shiyajian
 * create: 2023-06-20
 */
@SpringBootTest
public class HelloDubboImplTest {

    @Autowired
    private HelloDubboApi helloDubboApi;
}
