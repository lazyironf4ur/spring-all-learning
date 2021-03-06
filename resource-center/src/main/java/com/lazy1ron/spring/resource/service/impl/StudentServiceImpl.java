package com.lazy1ron.spring.resource.service.impl;

import com.lazy1ron.spring.resource.pojo.Student;
import com.lazy1ron.spring.resource.service.StudentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Primary;
import org.springframework.stereotype.Service;

import java.util.Map;

/**
 * @author:Lazy1ron
 * @date:2019/12/22 19:48
 */

@Service
@Primary
public class StudentServiceImpl implements StudentService {

    @Autowired
    private Map<Long, Object> cache;

    public void printBasicInfoById(Long id) {
        Student student = (Student) cache.get(id);
        System.out.println(student.toString());
    }
}
