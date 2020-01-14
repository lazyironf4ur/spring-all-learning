package com.lazy1ron.spring.data.access;

import com.lazy1ron.spring.core.ioc.container.MyAnnotationApplicationContext;
import com.lazy1ron.spring.data.config.DataAccessPackageScanConfig;
import org.junit.Assert;
import org.junit.Test;
import org.springframework.context.ApplicationContext;

/**
 * @author:Lazy1ron
 * @date:2020/1/14 18:54
 */


public class DataSourceBuilderTest {

    // @value test
    @Test
    public void test1() {
        ApplicationContext context = MyAnnotationApplicationContext.getContext(DataAccessPackageScanConfig.class);
        Assert.assertEquals(true, context.containsBean("builder"));
        context.getBean(DataSourceBuilder.class).showProperties();
    }
}
