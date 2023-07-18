package com.github.shiyajian.order;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.cloud.openfeign.EnableFeignClients;
import org.springframework.context.annotation.EnableAspectJAutoProxy;

/**
 * 系统启动类
 */
@SpringBootApplication
@EnableDiscoveryClient
@MapperScan("com.github.shiyajian.order.infrastructure.mapper.db")
@EnableAspectJAutoProxy
public class OrderCenterApplication {

    public static void main(String[] args) {
        SpringApplication.run(OrderCenterApplication.class);
    }
}
