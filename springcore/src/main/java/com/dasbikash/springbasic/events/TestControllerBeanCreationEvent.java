package com.dasbikash.springbasic.events;

import com.dasbikash.springbasic.controllers.TestController;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationEvent;
import org.springframework.stereotype.Component;

//@Component
public class TestControllerBeanCreationEvent extends ApplicationEvent {

    /*private TestController testController;

    @Autowired
    public void setTestController(TestController testController) {
        this.testController = testController;
    }*/

    public TestControllerBeanCreationEvent(Object source) {
        super(source);
    }

    /*@Override
    public Object getSource() {
        return testController;
    }*/
}
