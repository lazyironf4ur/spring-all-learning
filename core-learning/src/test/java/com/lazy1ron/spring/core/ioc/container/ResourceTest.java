package com.lazy1ron.spring.core.ioc.container;

import com.lazy1ron.spring.resource.service.EasyService;
import com.lazy1ron.spring.resource.service.ForeignService;
import com.lazy1ron.spring.resource.service.PropertiesService;
import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.context.MessageSource;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.core.env.Environment;
import org.springframework.util.CollectionUtils;

import java.util.*;

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
    // add classpath config file: otherbeans.xml
    @Test
    public void test3() {
        ConfigurableApplicationContext context = new ClassPathXmlApplicationContext("classpath*:xml/beans.xml",
                "classpath*:config/otherbeans.xml");

        EasyService easyService = context.getBean(EasyService.class);
        easyService.sayHello();

        ForeignService fs = (ForeignService) context.getBean("foreignService");
        fs.sayHello();

    }

    // MessageSource object for spring
    // what's diffrences between "classpath" and "classpath*" {@link https://blog.csdn.net/ji519974770/article/details/77248575}
    // i18n internationalization
    // TODO: 控制台输出中文乱码
    @Test
    public void test4() {

        MessageSource ms = new ClassPathXmlApplicationContext("classpath*:xml/beans.xml",
                "classpath*:config/otherbeans.xml");

        String message1 = ms.getMessage("message", null, "Default", Locale.CHINA);
        String message2 = ms.getMessage("argument.required", new String[]{"userDao"}, "Default", Locale.ENGLISH);

        System.out.println("message1: " + message1);
        System.out.println("message2: " + message2);
    }


    /**
     * @Author Lazy1ron
     * @Description: consider what it is a BeanFactoryPostProcessor.
     * it likes config metadata before any beans instantiated {@link org.springframework.context.support.PropertySourcesPlaceholderConfigurer}
     * example:
     *  <bean class="org.springframework.context.support.PropertySourcesPlaceholderConfigurer">
     *     <property name="locations" value="classpath:com/something/jdbc.properties"/>
     * </bean>
     *
     * <bean id="dataSource" destroy-method="close"
     *         class="org.apache.commons.dbcp.BasicDataSource">
     *     <property name="driverClassName" value="${jdbc.driverClassName}"/>
     *     <property name="url" value="${jdbc.url}"/>
     *     <property name="username" value="${jdbc.username}"/>
     *     <property name="password" value="${jdbc.password}"/>
     * </bean>
     **/
    @Test
    public void test5() {
        ApplicationContext context = new ClassPathXmlApplicationContext("classpath*:xml/beans.xml", "classpath*:config/otherbeans.xml");
        System.out.print("The Application Owner is: ");
        context.getBean(PropertiesService.class).printProperties();
    }
}
