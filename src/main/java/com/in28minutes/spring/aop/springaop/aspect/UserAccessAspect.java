package com.in28minutes.spring.aop.springaop.aspect;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.context.annotation.Configuration;

@Aspect
@Configuration
public class UserAccessAspect {

    private Logger logger = LoggerFactory.getLogger(this.getClass());

    //What methods would wanted to be intercepted
    //execution(* PACKAGE.*.(..))
    //execution maps a call to any class/method
    //* PACKAGE.*.*(..) = any * return type of given PACKAGE, of any class within package
    // for any given parameters

    // The Weaver weaves in the pointcuts from the join points

    @Before("com.in28minutes.spring.aop.springaop.aspect.CommonJoinPointConfig.dataLayerExecution()")
    public void before(JoinPoint joinPoint) {
        // what do I want to do
        // known as Advice
        logger.info("Check for user Access");
        logger.info("Permitted execution for {}", joinPoint);
    }

}
