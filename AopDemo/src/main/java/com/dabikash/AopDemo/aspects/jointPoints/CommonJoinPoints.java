package com.dabikash.AopDemo.aspects.jointPoints;

import org.aspectj.lang.annotation.Pointcut;

public class CommonJoinPoints {

    @Pointcut("execution(* com.dabikash.AopDemo..*(..))")
    public void allInBasePackage(){}

    @Pointcut("execution(* com.dabikash.AopDemo.business..*(..))")
    public void allInBusinessPackages(){}

    @Pointcut("execution(* com.dabikash.AopDemo.dao..*(..))")
    public void allInDataPackages(){}

    @Pointcut("execution(* com.dabikash.AopDemo.business.Business1.*(..))")
    public void allInBusinessPackage1(){}

    @Pointcut("execution(* com.dabikash.AopDemo.business.Business2.*(..))")
    public void allInBusinessPackage2(){}

    @Pointcut("allInBusinessPackage1() && allInBusinessPackage2()")
    public void inAllBusinessLayer(){}

    @Pointcut("bean(*dao*)")
    public void beanWithDao(){}

    @Pointcut("bean(dao*)")
    public void beanStartingWithDao(){}

    @Pointcut("bean(*dao)")
    public void beanEndingWithDao(){}

    @Pointcut("within(com.dabikash..*)")
    public void withinAllPackages(){}

    @Pointcut("@annotation(com.dabikash.AopDemo.aspects.TrackTime)")
    public void withTrackTimeAnnotation(){}

}
