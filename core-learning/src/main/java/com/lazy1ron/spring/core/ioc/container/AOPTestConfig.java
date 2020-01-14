package com.lazy1ron.spring.core.ioc.container;

import com.lazy1ron.spring.core.aspectj.AnnotatedAspectJ;
import com.lazy1ron.spring.core.aspectj.AspectJConfig;
import com.lazy1ron.spring.resource.service.impl.AspectJServiceImpl;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.FilterType;

/**
 * @author:Lazy1ron
 * @date:2020/1/10 4:15
 */

@ComponentScan(basePackages = "com.lazy1ron.spring",
        excludeFilters = {@ComponentScan.Filter(pattern = "^[aspectj]", type = FilterType.REGEX)})
public class AOPTestConfig {
}
