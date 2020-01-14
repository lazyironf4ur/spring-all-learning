package com.lazy1ron.spring.data.access;

import org.apache.commons.dbcp2.BasicDataSource;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * @author:Lazy1ron
 * @date:2020/1/14 17:02
 */

@Configuration("builder")
public class DataSourceBuilder {

    @Value("${data-access.driver.class.name}")
    private String DRIVER_CLASS_NAME;

    @Value("${data-access.url}")
    private String URL;

    @Value("${data-access.username}")
    private String USERNAME;

    @Value("${data-access.password}")
    private String PASSWORD;


    @Bean
    public BasicDataSource dataSource() {
        BasicDataSource dataSource = new BasicDataSource();
        dataSource.setDriverClassName(DRIVER_CLASS_NAME);
        dataSource.setUrl(URL);
        dataSource.setUsername(USERNAME);
        dataSource.setPassword(PASSWORD);

        return dataSource;
    }

    public void showProperties() {
        System.out.println(DRIVER_CLASS_NAME);
        System.out.println(URL);
        System.out.println(USERNAME);
        System.out.println(PASSWORD);
    }
}
