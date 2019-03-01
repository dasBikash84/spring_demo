package com.dabikash.AopDemo.business;

import com.dabikash.AopDemo.dao.Dao1;
import com.dabikash.AopDemo.dao.Dao2;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class Business2 {

    private Logger logger = LoggerFactory.getLogger(this.getClass());

    private Dao2 dao2;

    @Autowired
    public void setDao1(Dao2 dao2) {
        this.dao2 = dao2;
    }

    public String runMethod(){
        return dao2.retrieveData();
    }
}
