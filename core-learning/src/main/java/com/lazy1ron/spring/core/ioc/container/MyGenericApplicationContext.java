package com.lazy1ron.spring.core.ioc.container;


import org.springframework.context.annotation.AnnotatedBeanDefinitionReader;
import org.springframework.context.support.GenericApplicationContext;

/**
 * @author:Lazy1ron
 * @date:2019/12/24 1:25
 */
public class MyGenericApplicationContext {

    private static GenericApplicationContext context = new GenericApplicationContext();

    // add BeanPostProcessor
    private MyGenericApplicationContext() {}

    public static <T extends GenericApplicationContext> T getContext() {
        AnnotatedBeanDefinitionReader reader = new AnnotatedBeanDefinitionReader(context);
        reader.register(PackageScanConfig.class);
        context.refresh();
        return (T)context;
    }


}
