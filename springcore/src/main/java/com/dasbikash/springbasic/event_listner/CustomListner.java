package com.dasbikash.springbasic.event_listner;

import org.springframework.boot.context.event.ApplicationReadyEvent;
import org.springframework.context.ApplicationEvent;
import org.springframework.context.ApplicationListener;
import org.springframework.stereotype.Component;

@Component
public class CustomListner implements ApplicationListener<ApplicationReadyEvent> {
    /*@Override
    public void onApplicationEvent(ApplicationEvent event) {
    }*/

    @Override
    public void onApplicationEvent(ApplicationReadyEvent event) {
        System.out.println("\n\nFrom Event Listner.\nEvent Type:"+event.getClass().getCanonicalName());
    }
}
