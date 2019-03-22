package com.dasbikash.springbasic.bean_configs;

import com.dasbikash.springbasic.controllers.TestController;
import org.springframework.beans.factory.config.ConfigurableBeanFactory;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Scope;

@Configuration
public class CustomBeanConfigs {

    @Bean//("testCon")
    public TestController getTestController(){
        return new TestController();
    }
}
