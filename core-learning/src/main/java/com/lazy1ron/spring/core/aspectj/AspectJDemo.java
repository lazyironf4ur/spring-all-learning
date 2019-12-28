package com.lazy1ron.spring.core.aspectj;

/**
 * @author:Lazy1ron
 * @date:2019/12/28 17:26
 */

public class AspectJDemo {

    public void sayHello() {
        System.out.println("this is a test for aspectj");
    }

    public static void main(String[] args) {
        new AspectJDemo().sayHello();
    }
}
