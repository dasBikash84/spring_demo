package com.dasbikash.springbasic.post_processor;

import org.springframework.beans.BeansException;
import org.springframework.beans.factory.config.BeanPostProcessor;
import org.springframework.stereotype.Component;

@Component("DisplayNamePostProcessor")
public class DisplayNamePostProcessor implements BeanPostProcessor {
    @Override
    public Object postProcessBeforeInitialization(Object bean, String beanName) throws BeansException {
        if (beanName.equals("testCon")) {
            System.out.println("postProcessBeforeInitialization called for bean: " + beanName);
        }
        return bean;
    }

    @Override
    public Object postProcessAfterInitialization(Object bean, String beanName) throws BeansException {
        //if (beanName.equals("testCon")) {
            System.out.println("postProcessAfterInitialization called for bean: "+beanName+" of class:" + bean.getClass().getSimpleName());
        //}
        return bean;
    }
}
