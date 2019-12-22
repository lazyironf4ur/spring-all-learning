package com.lazy1ron.spring.core.ioc.container;

import com.lazy1ron.spring.commons.servicedesign.PersonService;
import com.lazy1ron.spring.resource.pojo.Student;
import org.junit.Test;
import org.springframework.context.ApplicationContext;

import java.util.Map;

/**
 * @author:Lazy1ron
 * @date:2019/12/22 21:54
 */

public class ContainerTest {

    @Test
    public void test1() {

        ApplicationContext context = MyAnnotationApplicationContext.getContext();

        Map data = (Map) context.getBean("cache");

        data.put(1L, new Student(1L, "lazy1ron", 20));

        PersonService service = context.getBean(PersonService.class);

        service.printBasicInfoById(Long.valueOf(1L));



    }

}
