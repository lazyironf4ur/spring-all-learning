package com.lazy1ron.spring.core.ioc.container;


import org.springframework.beans.factory.config.BeanPostProcessor;
import org.springframework.context.annotation.AnnotatedBeanDefinitionReader;
import org.springframework.context.support.GenericApplicationContext;

import java.util.Arrays;
import java.util.List;

/**
 * @author:Lazy1ron
 * @date:2019/12/24 1:25
 */
public class MyGenericApplicationContext {

    private static GenericApplicationContext context = new GenericApplicationContext();
    
    private static Object lock = new Object();

    // to judge the context had been invoked {@refresh()} method
    private static boolean refreshed = false;

    // add BeanPostProcessor
    private MyGenericApplicationContext() {}

    public static <T extends GenericApplicationContext> T getContext() {
        if (!refreshed) {
            synchronized (lock) {
                if (!refreshed) {
                    refreshed ^= refreshed;
                    AnnotatedBeanDefinitionReader reader = new AnnotatedBeanDefinitionReader(context);
                    reader.register(PackageScanConfig.class);
                    context.refresh();

                }
            }
        }
        return (T)context;
    }
    
    public static <T extends GenericApplicationContext> T getContext(BeanPostProcessor ...beanPostProcessors) {
        if (!refreshed) {
            synchronized (lock) {
                if (!refreshed) {
                    AnnotatedBeanDefinitionReader reader = new AnnotatedBeanDefinitionReader(context);
                    reader.register(PackageScanConfig.class);
                    List<BeanPostProcessor> processorList = Arrays.asList(beanPostProcessors);
                    processorList.forEach((o) -> {
                        reader.registerBean(o.getClass());
                    });
                    context.refresh();
                }
            }
        }
        return (T)context;
    }


}
