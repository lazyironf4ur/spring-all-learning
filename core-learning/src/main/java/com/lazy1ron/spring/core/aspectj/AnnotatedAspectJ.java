package com.lazy1ron.spring.core.aspectj;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.annotation.Pointcut;


/**
 * TODO
 * @author:Lazy1ron
 * @date:2019/12/28 15:31
 */
@Aspect
public class AnnotatedAspectJ {

    //@Pointcut("execution(* com.lazy1ron.spring.resource.service.impl.AspectJServiceImpl.print())")
    //public void printPoint() {
    //
    //}
    //
    //@Pointcut("execution(* com.lazy1ron.spring.core.aspectj.AspectJDemo.sayHello())")
    //public void sayHelloPoint() {
    //
    //}

    //@Before("printPoint()")
    //public void aroundPrintPoint(JoinPoint joinPoint) {
    //    System.out.println("test aspect");
    //    System.out.println(joinPoint);
    //    System.out.println(joinPoint.getSourceLocation());
    //}

    @Before("execution(* com.lazy1ron.spring.core.aspectj.AspectJDemo.sayHello())")
    public void aroundSayHelloPoint(JoinPoint joinPoint) {
        System.out.println("test aspect");
        System.out.println(joinPoint);
        System.out.println(joinPoint.getSourceLocation());
    }
}
