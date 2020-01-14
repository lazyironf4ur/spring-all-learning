package com.lazy1ron.spring.data.access;

import com.lazy1ron.spring.core.ioc.container.MyAnnotationApplicationContext;
import com.lazy1ron.spring.data.config.DataAccessPackageScanConfig;
import org.apache.commons.dbcp2.BasicDataSource;
import org.junit.Assert;
import org.junit.Test;
import org.springframework.context.ApplicationContext;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

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

    // obtain the DBCP's BasicDataBase intance
    @Test
    public void test2() {

        ApplicationContext context = MyAnnotationApplicationContext.getContext(DataAccessPackageScanConfig.class);
        Assert.assertEquals(true, context.containsBean("dataSource"));
        BasicDataSource dataSource = (BasicDataSource) context.getBean("dataSource");
        try {
            Connection connection = dataSource.getConnection();
            Statement statement = connection.createStatement();
            statement.execute("show tables;");
            ResultSet resultSet = statement.getResultSet();
            while (resultSet.next()) {
                byte[] bytes = resultSet.getBytes(1);
                System.out.println("table name: " + new String(bytes));
            }
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            // ?
        }
    }
}
