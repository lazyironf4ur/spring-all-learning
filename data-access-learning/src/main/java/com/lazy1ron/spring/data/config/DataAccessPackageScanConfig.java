package com.lazy1ron.spring.data.config;

import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.PropertySource;

/**
 * @author:Lazy1ron
 * @date:2020/1/14 18:58
 */

@ComponentScan(basePackages = {"com.lazy1ron.spring.data"})
@PropertySource("datasource.properties")
public class DataAccessPackageScanConfig {
}
