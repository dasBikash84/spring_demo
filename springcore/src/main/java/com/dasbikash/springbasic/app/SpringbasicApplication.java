package com.dasbikash.springbasic.app;

import com.dasbikash.springbasic.controllers.TestController;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.*;

@SpringBootApplication
@ComponentScans(value = {
        @ComponentScan(basePackages = {"com.dasbikash.springbasic.controllers","com.dasbikash.springbasic.bean_configs"}),
        @ComponentScan(basePackages = "com.dasbikash.springbasic.event_listner"),
        @ComponentScan(basePackages = "com.dasbikash.springbasic.post_processor")
})
@PropertySources(
        {
                @PropertySource("classpath:application.properties"),
                @PropertySource("classpath:custom.properties")
        }
    )
@ImportResource("classpath:bean-config.xml")
public class SpringbasicApplication implements CommandLineRunner {

    private TestController testController;

    @Value("${first.name}")
    private String firstName;
    @Value("${last.name}")
    private String lastName;


    @SuppressWarnings("SpringJavaInjectionPointsAutowiringInspection")
    @Autowired
    @Qualifier("testConFromXml")
    public void setTestController(TestController testController) {
        this.testController = testController;
    }

    Logger logger = LoggerFactory.getLogger(this.getClass());

    public static void main(String[] args) {
        ApplicationContext applicationContext =
                SpringApplication.run(SpringbasicApplication.class, args);
    }

    @Override
    public void run(String... args) throws Exception {
        logger.info("My name: {} {}",firstName,lastName);
        testController.publishEvent();
    }
}
