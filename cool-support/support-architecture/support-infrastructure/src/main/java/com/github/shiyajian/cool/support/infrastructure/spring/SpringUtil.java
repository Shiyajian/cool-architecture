package com.github.shiyajian.cool.support.infrastructure.spring;

import org.springframework.context.ApplicationContext;
import org.springframework.context.ApplicationContextAware;

/**
 * @author shiyajian
 * create: 2022-08-18
 */
public class SpringUtil implements ApplicationContextAware {

    private static ApplicationContext context;

    @Override
    public void setApplicationContext(ApplicationContext context) {
        SpringUtil.context = context;
    }

    public static <T> T getBean(Class<T> type) {
        return context.getBean(type);
    }

    public static <T> T getBean(String name, Class<T> clazz) {
        return context.getBean(name, clazz);
    }

    public static String getProperty(String key) {
        if (null == context) {
            return null;
        }
        return context.getEnvironment().getProperty(key);
    }

    public static String getApplicationName() {
        return getProperty("spring.application.name");
    }

    public static String[] getActiveProfiles() {
        if (null == context) {
            return null;
        }
        return context.getEnvironment().getActiveProfiles();
    }

    public static String getActiveProfile() {
        final String[] activeProfiles = getActiveProfiles();
        return (activeProfiles != null && activeProfiles.length > 0) ? activeProfiles[0] : null;
    }

}
