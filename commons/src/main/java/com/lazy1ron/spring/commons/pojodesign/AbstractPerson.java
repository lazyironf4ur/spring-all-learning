package com.lazy1ron.spring.commons.pojodesign;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.ToString;

/**
 * @author:Lazy1ron
 * @date:2019/12/22 19:38
 */

@AllArgsConstructor
@ToString
public abstract class AbstractPerson {

    private Long id;

    //姓名
    private String name;

    //年龄
    private Integer age;


}
