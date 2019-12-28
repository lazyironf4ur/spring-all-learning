package com.lazy1ron.spring.resource.service.impl;

import com.lazy1ron.spring.resource.service.AspectJService;
import org.springframework.stereotype.Service;

/**
 * @author:Lazy1ron
 * @date:2019/12/28 15:34
 */

@Service
public class AspectJServiceImpl implements AspectJService {


    @Override
    public void print() {
        System.out.println("this is a aspect oriented method");
    }
}
