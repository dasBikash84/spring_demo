package com.dasbikash.springbasic.controllers;

import com.dasbikash.springbasic.events.TestControllerBeanCreationEvent;
import org.springframework.beans.BeansException;
import org.springframework.beans.factory.*;
import org.springframework.beans.factory.config.BeanPostProcessor;
import org.springframework.context.ApplicationContext;
import org.springframework.context.ApplicationContextAware;
import org.springframework.context.ApplicationEventPublisher;
import org.springframework.context.ApplicationEventPublisherAware;
import org.springframework.context.annotation.Primary;
import org.springframework.stereotype.Component;

import javax.annotation.PostConstruct;
import javax.annotation.PreDestroy;
import javax.annotation.Resource;

@Component("testControllerBean")
@Primary
public class TestController implements
        ApplicationContextAware, BeanNameAware, BeanFactoryAware,
        InitializingBean, DisposableBean, ApplicationEventPublisherAware {

    public String sayHello(){
        return "hello";
    }


    private BeanPostProcessor beanPostProcessor;
    private ApplicationEventPublisher mApplicationEventPublisher;
    private String mBeanName;

    public String getBeanName() {
        return mBeanName;
    }

    //@Autowired

    /*public TestController(@Qualifier("DisplayNamePostProcessor") BeanPostProcessor beanPostProcessor) {
        this.beanPostProcessor = beanPostProcessor;
    }*/

    //@Autowired
    //@Qualifier("DisplayNamePostProcessor")
    @Resource(name="DisplayNamePostProcessor")
    public void setBeanPostProcessor(BeanPostProcessor beanPostProcessor) {
        this.beanPostProcessor = beanPostProcessor;
    }

    @Override
    public void setApplicationContext(ApplicationContext applicationContext) throws BeansException {
        //System.out.println("From setApplicationContext: "+applicationContext.getClass().getCanonicalName());
    }

    @Override
    public void setBeanName(String name) {
        //System.out.println("From setBeanName with bean name:"+name);
        mBeanName = name;
    }

    @Override
    public void afterPropertiesSet() throws Exception {
        //System.out.println("From afterPropertiesSet()");
        //System.out.println("beanPostProcessor: "+beanPostProcessor);
    }
    @PostConstruct
    public void postConstruct() {
        //System.out.println("From postConstruct()");
        //System.out.println("beanPostProcessor: "+beanPostProcessor);
    }

    @Override
    public void destroy() throws Exception {
        //System.out.println("beanPostProcessor: "+beanPostProcessor);
       //System.out.println("From destroy()");

    }

    @PreDestroy
    public void preDestroy() throws Exception {
        //System.out.println("beanPostProcessor: "+beanPostProcessor);
       //System.out.println("From PreDestroy()");

    }

    @Override
    public void setBeanFactory(BeanFactory beanFactory) throws BeansException {
        //System.out.println("From setBeanFactory: "+beanFactory.getClass().getCanonicalName());
    }

    @Override
    public void setApplicationEventPublisher(ApplicationEventPublisher applicationEventPublisher) {
        mApplicationEventPublisher=applicationEventPublisher;
    }

    public void publishEvent(){
        mApplicationEventPublisher.publishEvent(new TestControllerBeanCreationEvent(this));
    }
}
