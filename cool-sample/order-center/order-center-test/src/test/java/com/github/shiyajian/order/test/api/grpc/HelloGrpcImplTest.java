package com.github.shiyajian.order.test.api.grpc;

import com.github.shiyajian.order.api.dubbo.hello.HelloDubboApi;
import com.github.shiyajian.order.api.grpc.HelloGrpcApi;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

/**
 * @author shiyajian
 * create: 2023-06-20
 */
@SpringBootTest
public class HelloGrpcImplTest {

    @Autowired
    private HelloGrpcApi helloGrpcApi;
}
