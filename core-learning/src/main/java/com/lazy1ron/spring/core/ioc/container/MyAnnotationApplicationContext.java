package com.lazy1ron.spring.core.ioc.container;

import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

/**
 * @author:Lazy1ron
 * @date:2019/12/22 21:50
 */

public class MyAnnotationApplicationContext {

    private static ApplicationContext context = new AnnotationConfigApplicationContext(PackageScanConfig.class);

    public static<T extends ApplicationContext> T getContext() {
        return (T) context;
    }
}
