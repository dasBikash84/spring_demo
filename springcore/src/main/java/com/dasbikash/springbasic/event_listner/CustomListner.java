package com.dasbikash.springbasic.event_listner;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.context.event.ApplicationReadyEvent;
import org.springframework.context.ApplicationEvent;
import org.springframework.context.ApplicationListener;
import org.springframework.stereotype.Component;

@Component
public class CustomListner implements ApplicationListener {

    Logger logger = LoggerFactory.getLogger(this.getClass());

    @Override
    public void onApplicationEvent(ApplicationEvent event) {
        logger.info("Intercepted event {} of source {}",event.getClass().getCanonicalName(),event.getSource().toString());
    }

    /*@Override
    public void onApplicationEvent(ApplicationReadyEvent event) {
        System.out.println("\n\nFrom Event Listner.\nEvent Type:"+event.getClass().getCanonicalName());
    }*/
}
