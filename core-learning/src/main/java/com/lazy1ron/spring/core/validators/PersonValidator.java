package com.lazy1ron.spring.core.validators;

import org.springframework.validation.Errors;
import org.springframework.validation.Validator;

/**
 * TODO
 * @author:Lazy1ron
 * @date:2019/12/28 9:54
 */
public class PersonValidator implements Validator {


    @Override
    public boolean supports(Class<?> clazz) {
        return false;
    }

    @Override
    public void validate(Object target, Errors errors) {

    }
}
