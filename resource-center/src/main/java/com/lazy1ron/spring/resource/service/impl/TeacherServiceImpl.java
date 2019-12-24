package com.lazy1ron.spring.resource.service.impl;

import com.lazy1ron.spring.resource.pojo.Teacher;
import com.lazy1ron.spring.resource.service.TeacherService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Map;

/**
 * @author:Lazy1ron
 * @date:2019/12/25 1:19
 */
@Service
public class TeacherServiceImpl implements TeacherService {

    @Autowired
    private Map<Long, Object> cache;

    @Override
    public void printBasicInfoById(Long id) {
        Teacher teacher = (Teacher) cache.get(id);
        System.out.println(teacher.toString());
    }
}
