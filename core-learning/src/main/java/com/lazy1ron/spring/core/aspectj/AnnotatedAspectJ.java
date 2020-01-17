package com.lazy1ron.spring.core.aspectj;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.annotation.Pointcut;
import org.springframework.stereotype.Component;


/**
 * @author:Lazy1ron
 * @date:2019/12/28 15:31
 */
@Component
@Aspect
public class AnnotatedAspectJ {

    // implementing method pointcut
    @Pointcut("execution(* com.lazy1ron.spring.resource.service.impl.AspectJServiceImpl.print())")
    public void printPoint1() {

    }

    // interface method pointcut
    @Pointcut("execution(* com.lazy1ron.spring.resource.service.AspectJService.print())")
    public void printPoint2() {

    }

    @Pointcut("execution(* com.lazy1ron.spring.core.aspectj.AspectJDemo.sayHello())")
    public void sayHelloPoint() {

    }

    @Before("printPoint1()")
    public void aroundPrintPoint1(JoinPoint joinPoint) throws Throwable {
        System.out.println("implementing method pointcut");
        System.out.println(joinPoint);
        System.out.println(joinPoint.getSourceLocation());
    }

    @Before("printPoint2()")
    public void aroundPrintPoint2(JoinPoint joinPoint) throws Throwable {
        System.out.println("interface method pointcut");
        System.out.println(joinPoint);
        System.out.println(joinPoint.getSourceLocation());
    }

    @Around("execution(* com.lazy1ron.spring.core.aspectj.AspectJDemo.sayHello())")
    public void aroundSayHelloPoint(ProceedingJoinPoint joinPoint) {
        try {
            joinPoint.proceed();
        } catch (Throwable throwable) {
            throwable.printStackTrace();
        }
        System.out.println("test aspect");
        System.out.println(joinPoint);
        System.out.println(joinPoint.getSourceLocation());


    }
}
