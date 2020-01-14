package com.lazy1ron.spring.core.ioc.container;

import com.lazy1ron.spring.commons.servicedesign.PersonService;
import org.springframework.beans.factory.FactoryBean;
import org.springframework.lang.Nullable;
import org.springframework.stereotype.Component;

import java.util.Arrays;
import java.util.List;

/**
 * @author:Lazy1ron
 * @date:2019/12/24 20:14
 */

@Component
public class ServiceFactory<T extends PersonService> implements FactoryBean<T> {

    private T[] object;

    public ServiceFactory(@Nullable T ...t) {
        if (t == null) {
            return;
        }
        object = t;
    }

    @Override
    public T getObject() throws Exception {
        List<T> list =  Arrays.asList(object);
        list.forEach((o) -> {
            System.out.println("Now, you are using the" + o.getClass().getName());
        });

        return object[0];
    }

    @Override
    public Class<?> getObjectType() {
        return object[0].getClass();
    }
}
