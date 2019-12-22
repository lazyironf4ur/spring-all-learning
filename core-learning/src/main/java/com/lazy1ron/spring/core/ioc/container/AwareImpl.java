package com.lazy1ron.spring.core.ioc.container;

import org.springframework.beans.BeansException;
import org.springframework.context.ApplicationContext;
import org.springframework.context.ApplicationContextAware;
import org.springframework.stereotype.Component;

/**
 * @author:Lazy1ron
 * @date:2019/12/23 2:21
 */

@Component
public class AwareImpl implements ApplicationContextAware {

    public static ApplicationContext context = null;

    @Override
    public void setApplicationContext(ApplicationContext applicationContext) throws BeansException {
        context = applicationContext;
    }

    public static ApplicationContext getContext() {
        return context;
    }

    public static <T> T getBean(String name) {
        return (T) getContext().getBean(name);
    }

    public static <T> T getBean(Class<T> requiredType) {
        return (T) getContext().getBean(requiredType);
    }

    public static <T> T getBean(String name, Class<T> requiredType) {
        return (T) getContext().getBean(name, requiredType);
    }
}
