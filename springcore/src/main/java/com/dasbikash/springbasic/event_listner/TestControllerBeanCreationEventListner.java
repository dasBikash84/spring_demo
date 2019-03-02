package com.dasbikash.springbasic.event_listner;


import com.dasbikash.springbasic.controllers.TestController;
import com.dasbikash.springbasic.events.TestControllerBeanCreationEvent;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.context.ApplicationListener;
import org.springframework.stereotype.Component;

@Component
public class TestControllerBeanCreationEventListner implements ApplicationListener<TestControllerBeanCreationEvent> {

    Logger logger = LoggerFactory.getLogger(this.getClass());
    @Override
    public void onApplicationEvent(TestControllerBeanCreationEvent event) {
        logger.info("Intercepted event {} of source bean {}",event.getClass().getCanonicalName(),((TestController)event.getSource()).getBeanName());
    }
}
