package com.in28minutes.spring.aop.springaop.aspect;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.*;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.context.annotation.Configuration;

@Aspect
@Configuration
public class AfterAopAspect {

    private Logger logger = LoggerFactory.getLogger(this.getClass());

    //What methods would wanted to be intercepted
    //execution(* PACKAGE.*.(..))
    //execution maps a call to any class/method
    //* PACKAGE.*.*(..) = any * return type of given PACKAGE, of any class within package
    // for any given parameters

    // The Weaver weaves in the pointcuts from the join points

    @AfterReturning(
            value="com.in28minutes.spring.aop.springaop.aspect.CommonJoinPointConfig.businessLayerExecution()",
            returning="result")
    public void afterReturning(JoinPoint joinPoint, Object result) {
        // what do I want to do
        // known as Advice
        logger.info("{} returned with value {}", joinPoint,result);
    }

/*    @AfterThrowing(
            value="com.in28minutes.spring.aop.springaop.aspect.CommonJoinPointConfig.businessLayerExecution()",
            throwing="exception")
    public void afterReturning(JoinPoint joinPoint, Exception exception) {
        // what do I want to do
        // known as Advice
        logger.info("{} exception caught {}", joinPoint,exception);
    }*/

    @After("com.in28minutes.spring.aop.springaop.aspect.CommonJoinPointConfig.businessLayerExecution()")
    public void after(JoinPoint joinPoint) {
        // what do I want to do
        // known as Advice
        logger.info("After execution {}", joinPoint);
    }

}
