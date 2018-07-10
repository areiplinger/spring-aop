package com.in28minutes.spring.aop.springaop.aspect;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.*;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.context.annotation.Configuration;

@Aspect
@Configuration
public class MethodExecutionCalculationAspect {

    private Logger logger = LoggerFactory.getLogger(this.getClass());

    //What methods would wanted to be intercepted
    //execution(* PACKAGE.*.(..))
    //execution maps a call to any class/method
    //* PACKAGE.*.*(..) = any * return type of given PACKAGE, of any class within package
    // for any given parameters

    // The Weaver weaves in the pointcuts from the join points

    @Around("com.in28minutes.spring.aop.springaop.aspect.CommonJoinPointConfig.trackTimeAnnotation()")
    public void around(ProceedingJoinPoint joinPoint) throws  Throwable{
        long startTime = System.currentTimeMillis();
        joinPoint.proceed();
        long timeTaken = System.currentTimeMillis() - startTime;
        // what do I want to do
        // known as Advice
        logger.info("Time taken by {} is {}", joinPoint, timeTaken);
    }

}
