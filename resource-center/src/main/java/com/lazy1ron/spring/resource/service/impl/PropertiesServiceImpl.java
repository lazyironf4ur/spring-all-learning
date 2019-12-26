package com.lazy1ron.spring.resource.service.impl;

import com.lazy1ron.spring.resource.pojo.OwnerMessage;
import com.lazy1ron.spring.resource.service.PropertiesService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * @author:Lazy1ron
 * @date:2019/12/27 1:58
 */

@Service
public class PropertiesServiceImpl implements PropertiesService {

    @Autowired
    private OwnerMessage om;

    @Override
    public void printProperties() {
        System.out.println(om.getOwnername());
    }
}
