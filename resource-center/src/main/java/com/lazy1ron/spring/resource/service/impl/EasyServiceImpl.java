package com.lazy1ron.spring.resource.service.impl;

import com.lazy1ron.spring.resource.service.EasyService;
import org.springframework.stereotype.Service;

/**
 * @author:Lazy1ron
 * @date:2019/12/23 2:54
 */


@Service
public class EasyServiceImpl implements EasyService {

    @Override
    public void sayHello() {
        System.out.println("halo");
    }
}
