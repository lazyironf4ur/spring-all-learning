package com.lazy1ron.spring.core.ioc.container;

import lombok.Getter;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;

/**
 * @author:Lazy1ron
 * @date:2019/12/22 21:50
 */
@Configuration
@ComponentScan({"com.lazy1ron.spring"})
public class MyAnnotationApplicationContext {

    private static ApplicationContext context = new AnnotationConfigApplicationContext(MyAnnotationApplicationContext.class);

    public static ApplicationContext getContext() {
        return context;
    }
}
