package com.lazy1ron.spring.resource.service.impl;

import com.lazy1ron.spring.resource.service.ForeignService;

/**
 * 一个外部bean,没有被@Service标注
 * @author:Lazy1ron
 * @date:2019/12/22 23:21
 */
public class ForeignServiceImpl implements ForeignService {

    @Override
    public void sayHello() {
        System.out.println("Hi, i'm Lazy1ron. Nice to meet you");
    }
}
