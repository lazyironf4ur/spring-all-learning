package com.lazy1ron.spring.core.ioc.container;

import com.lazy1ron.spring.resource.service.EasyService;
import com.lazy1ron.spring.resource.service.ForeignService;
import org.junit.Test;
import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.core.env.Environment;
import org.springframework.util.CollectionUtils;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Iterator;
import java.util.List;

/**
 * @author:Lazy1ron
 * @date:2019/12/26 1:16
 */


public class ResourceTest {

    @Test
    public void test1() {
        ConfigurableApplicationContext context = MyGenericApplicationContext.getContext();
        Environment env = context.getEnvironment();
        List<String> envList = new ArrayList<>(Arrays.asList(env.getActiveProfiles()));
        Iterator it = envList.iterator();
        if (it.hasNext()) {
            System.out.println(it.next());
        }
    }

    // obtain JVM Runtiming Properties
    @Test
    public void test2() {
        System.out.println(System.getProperty("spring.application.name"));
    }


    // use xml metadata to initialize a context
    @Test
    public void test3() {
        ConfigurableApplicationContext context = new ClassPathXmlApplicationContext("classpath*:xml/beans.xml");

        EasyService easyService = context.getBean(EasyService.class);
        easyService.sayHello();

        ForeignService fs = (ForeignService) context.getBean("foreignService");
        fs.sayHello();


    }
}
