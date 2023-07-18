package com.github.shiyajian.order.test.api.feign;

import com.github.shiyajian.order.api.feign.hello.HelloFeignApi;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

/**
 * @author shiyajian
 * create: 2023-06-20
 */
@SpringBootTest
public class HelloFeignImplTest {

    @Autowired
    private HelloFeignApi helloFeignApi;
}
