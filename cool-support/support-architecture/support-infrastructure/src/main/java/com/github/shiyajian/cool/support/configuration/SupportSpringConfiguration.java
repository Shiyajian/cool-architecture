package com.github.shiyajian.cool.support.configuration;

import com.github.shiyajian.cool.support.infrastructure.spring.SpringUtil;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * @author shiyajian
 * create: 2023-06-10
 */
@Configuration
public class SupportSpringConfiguration {

    @Bean
    public SpringUtil springUtil() {
        return new SpringUtil();
    }
}
