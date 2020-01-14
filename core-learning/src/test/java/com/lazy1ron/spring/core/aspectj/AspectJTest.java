package com.lazy1ron.spring.core.aspectj;

import com.lazy1ron.spring.core.ioc.container.AOPTestConfig;
import com.lazy1ron.spring.core.ioc.container.MyAnnotationApplicationContext;
import com.lazy1ron.spring.resource.service.AspectJService;
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
    @Test
    public  void test2() {

        ApplicationContext context = MyAnnotationApplicationContext.getContext(AOPTestConfig.class);
        context.getBean(AspectJService.class).print();
    }

}
