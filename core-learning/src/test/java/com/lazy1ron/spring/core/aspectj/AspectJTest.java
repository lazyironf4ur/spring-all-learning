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

    @Test
    public void test2() {
        AspectJService ajs = new AspectJServiceImpl();
        ajs.print();
    }
}