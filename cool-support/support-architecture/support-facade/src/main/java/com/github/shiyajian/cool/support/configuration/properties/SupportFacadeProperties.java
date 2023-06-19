package com.github.shiyajian.cool.support.configuration.properties;

import lombok.Data;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.stereotype.Component;

/**
 * @author shiyajian
 * create: 2023-06-11
 */
@Component
@Data
@ConfigurationProperties("support.facade")
public class SupportFacadeProperties {
}
