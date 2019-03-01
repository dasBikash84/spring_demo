package com.dabikash.AopDemo.aspects;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.context.annotation.Configuration;

//@Configuration
//@Aspect
public class BeforeAspect {

    private Logger logger = LoggerFactory.getLogger(this.getClass());

    @Before("com.dabikash.AopDemo.aspects.jointPoints.CommonJoinPoints.allInBasePackage()")
    public void beforeAll(JoinPoint joinPoint){
        logger.info("Before Intercepted Method of all : {}",joinPoint);
    }

    @Before("com.dabikash.AopDemo.aspects.jointPoints.CommonJoinPoints.allInBasePackage()")
    public void beforeAllBusiness(JoinPoint joinPoint){
        logger.info("Before Intercepted Method of all Business : {}",joinPoint);
    }

    @Before("com.dabikash.AopDemo.aspects.jointPoints.CommonJoinPoints.allInBusinessPackage1()")
    public void beforeAllBusiness1(JoinPoint joinPoint){
        logger.info("Before Intercepted Method of Business1: {}",joinPoint);
    }

    @Before("com.dabikash.AopDemo.aspects.jointPoints.CommonJoinPoints.allInBusinessPackage2()")
    public void beforeAllBusiness2(JoinPoint joinPoint){
        logger.info("Before Intercepted Method of Business2: {}",joinPoint);
    }


}
