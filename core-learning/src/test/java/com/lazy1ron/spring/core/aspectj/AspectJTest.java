package com.lazy1ron.spring.core.aspectj;

import com.lazy1ron.spring.core.ioc.container.MyAnnotationApplicationContext;
import com.lazy1ron.spring.resource.service.AspectJService;
import com.lazy1ron.spring.resource.service.impl.AspectJServiceImpl;
import org.junit.Test;
import org.springframework.context.ApplicationContext;

/**
 * @author:Lazy1ron
 * @date:2019/12/28 14:46
 */
public class AspectJTest {

    @Test
    public void test1() {
        ApplicationContext context = MyAnnotationApplicationContext.getContext();
        AspectJService as = context.getBean(AspectJService.class);
        as.print();
    }


    // test how aspect bean and proxy object generated for the those object advised alone.
    // proxied by Java Dynamic Proxy
    @Test
    public  void test2() {
        ApplicationContext context = MyAnnotationApplicationContext.getContext(AspectJConfig.class, AnnotatedAspectJ.class, AspectJServiceImpl.class);
        AspectJService aspectJService = context.getBean(AspectJService.class);
        System.out.println(aspectJService.getClass().toString());
        aspectJService.print();
    }

    // proxied by cglib
    @Test
    public  void test3() {
        ApplicationContext context = MyAnnotationApplicationContext.getContext(AspectJConfig.class, AnnotatedAspectJ.class, AspectJDemo.class);
        AspectJDemo demo = context.getBean(AspectJDemo.class);
        System.out.println(demo.getClass().toString());
        demo.sayHello();
    }
}
