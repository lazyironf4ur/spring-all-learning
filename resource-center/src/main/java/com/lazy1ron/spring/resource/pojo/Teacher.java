package com.lazy1ron.spring.resource.pojo;

import com.lazy1ron.spring.commons.pojodesign.AbstractPerson;

/**
 * @author:Lazy1ron
 * @date:2019/12/25 1:34
 */
public class Teacher extends AbstractPerson {

    private String type;

    @Override
    public String toString() {
        return super.toString();
    }

    public Teacher(Long id, String name, Integer age, String type) {
        super(id, name, age);
        this.type = type;
    }
}
