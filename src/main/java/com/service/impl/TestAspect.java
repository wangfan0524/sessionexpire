package com.service.impl;

import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.springframework.stereotype.Component;

@Component
@Aspect
public class TestAspect {

    @Around("@annotation(com.annotaion.Authorize)")
    public Object doSetFieldValue(ProceedingJoinPoint point) throws Throwable{

        System.out.printf("rewrewre");
        return null;
    }
}
