package com.dabikash.AopDemo.aspects;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.*;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.context.annotation.Configuration;

//@Configuration
//@Aspect
public class AfterAspect {

    private Logger logger = LoggerFactory.getLogger(this.getClass());

    @AfterReturning(
            value = "com.dabikash.AopDemo.aspects.jointPoints.CommonJoinPoints.allInBasePackage()",
            returning = "returnValue"
    )
    public void afterRetuning(JoinPoint joinPoint,Object returnValue){
        logger.info("AfterReturning Intercepted Method of : {}",joinPoint);
        logger.info("Returned value : {}",returnValue);
    }

    @AfterThrowing(
            value = "com.dabikash.AopDemo.aspects.jointPoints.CommonJoinPoints.allInBusinessPackage1()",
            throwing = "returnValue"
    )
    public void afterThrowing(JoinPoint joinPoint,Throwable returnValue){
        logger.info("AfterThrowing Intercepted Method of : {}",joinPoint);
        logger.info("Returned value : {}",returnValue);
    }

    @After(
            value = "com.dabikash.AopDemo.aspects.jointPoints.CommonJoinPoints.allInBusinessPackage2()"
    )
    public void afterThrowing(JoinPoint joinPoint){
        logger.info("After Intercepted Method of : {}",joinPoint);
    }


}
