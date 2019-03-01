package com.dabikash.AopDemo.aspects;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.context.annotation.Configuration;

@Configuration
@Aspect
public class AroundAspect {

    private Logger logger = LoggerFactory.getLogger(this.getClass());

    @Around("com.dabikash.AopDemo.aspects.jointPoints.CommonJoinPoints.withinAllPackages()")
    public void aroundAdvice(ProceedingJoinPoint proceedingJoinPoint) throws Throwable {
        logger.info("Before Method : {}",proceedingJoinPoint);
        Long startTime = System.currentTimeMillis();
        proceedingJoinPoint.proceed();
        logger.info("Time taken : {} ms in execution of {}",System.currentTimeMillis()-startTime,proceedingJoinPoint);
        logger.info("After Method : {}",proceedingJoinPoint);
    }

    @Before("com.dabikash.AopDemo.aspects.jointPoints.CommonJoinPoints.withTrackTimeAnnotation()")
        public void aroundAdviceForAnotatedMethod(JoinPoint joinPoint) throws Throwable {
            logger.info("Anotated Method : {}",joinPoint);
        }

}
