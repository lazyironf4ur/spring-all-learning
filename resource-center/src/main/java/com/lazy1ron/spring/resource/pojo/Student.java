package com.lazy1ron.spring.resource.pojo;

import com.lazy1ron.spring.commons.pojodesign.AbstractPerson;

/**
 * @author:Lazy1ron
 * @date:2019/12/22 19:43
 */
public class Student extends AbstractPerson {


    public Student(Long id, String name, Integer age) {
        super(id, name, age);
    }


    @Override
    public String toString() {
        return super.toString();
    }
}
