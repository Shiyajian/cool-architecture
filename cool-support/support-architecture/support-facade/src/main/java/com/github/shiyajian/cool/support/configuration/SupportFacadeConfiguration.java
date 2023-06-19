package com.github.shiyajian.cool.support.configuration;

import com.github.shiyajian.cool.support.facade.endpoint.aspect.LogAspect;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * @author shiyajian
 * create: 2023-06-10
 */
@Configuration
public class SupportFacadeConfiguration {

    @Bean
    public LogAspect logAspect() {
        return new LogAspect();
    }


}
