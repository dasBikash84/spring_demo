package com.dasbikash.springbasic.bean_configs;

import com.dasbikash.springbasic.controllers.TestController;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class CustomBeanConfigs {

    @Bean("testCon")
    public TestController getTestController(){
        return new TestController();
    }
}
