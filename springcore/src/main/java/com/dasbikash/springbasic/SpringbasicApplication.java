package com.dasbikash.springbasic;

import com.dasbikash.springbasic.controllers.TestController;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;

@SpringBootApplication
public class SpringbasicApplication {

    public static void main(String[] args) {
        ApplicationContext applicationContext =
                SpringApplication.run(SpringbasicApplication.class, args);

        TestController testController =
                (TestController)applicationContext.getBean("testCon");



        System.out.println(testController.sayHello());
    }

}
