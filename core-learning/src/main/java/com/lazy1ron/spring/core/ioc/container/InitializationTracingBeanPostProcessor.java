package com.lazy1ron.spring.core.ioc.container;

import org.springframework.beans.BeansException;
import org.springframework.beans.factory.config.BeanPostProcessor;

/**
 * @author:Lazy1ron
 * @date:2019/12/24 0:41
 */


public class InitializationTracingBeanPostProcessor implements BeanPostProcessor {

    @Override
    public Object postProcessBeforeInitialization(Object bean, String beanName) throws BeansException {
        return bean;
    }

    @Override
    public Object postProcessAfterInitialization(Object bean, String beanName) throws BeansException {
        System.out.println(bean.getClass().getName() + ": " + beanName);
        return bean;
    }
}
