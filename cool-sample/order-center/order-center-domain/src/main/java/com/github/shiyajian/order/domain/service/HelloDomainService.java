package com.github.shiyajian.order.domain.service;

import com.github.shiyajian.order.domain.model.entity.Hello;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Component;

/**
 * @author shiyajian
 * create: 2023-01-16
 */
@Component
@Slf4j
public class HelloDomainService {

    /**
     * 校验地址是否合法
     */
    public boolean isLegalAddress(Hello hello) {
        if (hello == null) {
            return false;
        }
        return true;
    }
}
