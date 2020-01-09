package com.lazy1ron.spring.core.ioc.container;

import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

/**
 * @author:Lazy1ron
 * @date:2019/12/22 21:50
 */

public class MyAnnotationApplicationContext {

    private static final Class DEFAULT_CLASS = PackageScanConfig.class;

    private static ApplicationContext context;

    private Class<?>[] injectClasses;



    public static<T extends ApplicationContext> T getContext() {
        return doGetContext();
    }

    public static<T extends ApplicationContext> T getContext(Class<?> ...clazz) {

        return doGetContext(clazz);
    }

    private static <T extends ApplicationContext> T doGetContext(Class<?> ...classes) {
        if (classes.length == 0) {
            context = new AnnotationConfigApplicationContext(DEFAULT_CLASS);
            return (T)context;
        }

        context = new AnnotationConfigApplicationContext(classes);
        return (T)context;
    }
}
