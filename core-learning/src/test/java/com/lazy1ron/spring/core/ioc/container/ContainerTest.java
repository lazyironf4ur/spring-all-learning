package com.lazy1ron.spring.core.ioc.container;

import com.lazy1ron.spring.commons.servicedesign.PersonService;
import com.lazy1ron.spring.resource.pojo.Student;
import com.lazy1ron.spring.resource.service.EasyService;
import com.lazy1ron.spring.resource.service.ForeignService;
import com.lazy1ron.spring.resource.service.impl.ForeignServiceImpl;
import org.junit.Test;
import org.springframework.beans.factory.support.DefaultListableBeanFactory;
import org.springframework.context.ApplicationContext;
import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.context.support.GenericApplicationContext;
import java.util.Map;

/**
 * @author:Lazy1ron
 * @date:2019/12/22 21:54
 */

public class ContainerTest {

    /**
     * @Description: Use Context
     **/
    @Test
    public void test1() {

        ApplicationContext context = MyAnnotationApplicationContext.getContext();

        Map data = (Map) context.getBean("cache");

        data.put(1L, new Student(1L, "lazy1ron", 20));

        PersonService service = context.getBean(PersonService.class);

        service.printBasicInfoById(Long.valueOf(1L));

    }

    /**
     * @Description: add a foreign bean without Annotated to context
     **/

    @Test
    public void test2() {

        GenericApplicationContext context = (GenericApplicationContext) MyAnnotationApplicationContext.getContext();

        DefaultListableBeanFactory beanFactory = (DefaultListableBeanFactory) context.getBeanFactory();

        beanFactory.registerSingleton("foreign", new ForeignServiceImpl());

        //ForeignService fs = (ForeignService) beanFactory.getBean("foreign");
        //
        //fs.sayHello();

        ForeignService fs1 = (ForeignService) context.getBean("foreign");

        fs1.sayHello();
    }

    /**
     * @Description: get Beans from the other context autowired via implementing ApplicationContextAware
     **/
    @Test
    public void test3() {

        ApplicationContext origin = MyAnnotationApplicationContext.getContext();

        EasyService es = new ApplicationContextAwareImpl().getBean(EasyService.class);
        es.sayHello();
    }

    /**
     * @Description: Shutting Down the Spring IoC Container Gracefully in Non-Web Applications
     **/
    @Test
    public void test4() {

        ConfigurableApplicationContext context = MyAnnotationApplicationContext.getContext();

        context.registerShutdownHook();

    }

    /**
     * @Description: Customize BeanPostProcessor {@link com.lazy1ron.spring.core.ioc.container.InitializationTracingBeanPostProcessor}
     * in order to print class name and bean name of those bean initialized by Spring Container;
     **/
    @Test
    public void test5() {
        ConfigurableApplicationContext context = MyAnnotationApplicationContext.getContext();


    }

    // use AnnotatedBeanDefinitionReader to Inject Bean to a GenericApplicationContext
    @Test
    public void test6() {
        ApplicationContext context = MyGenericApplicationContext.getContext();

        context.getBean(EasyService.class).sayHello();
    }

    @Test
    public void test7() {
        // register your customize BeanPostProcessors to the Spring Container
        ApplicationContext context = MyGenericApplicationContext.getContext(new InitializationTracingBeanPostProcessor());
    }

}
