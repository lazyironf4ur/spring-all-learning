package com.lazy1ron.spring.core.ioc.container;

import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.FilterType;

/**
 * TODO
 * @author:Lazy1ron
 * @date:2019/12/25 12:09
 */

@ComponentScan(basePackages = {"com.lazy1ron.spring"},
        includeFilters = {@ComponentScan.Filter(type = FilterType.REGEX, pattern = {"*Impl.class"})})
public class AnotherPackageScanConfig {
}
