package com.dabikash.AopDemo.business;

import com.dabikash.AopDemo.dao.Dao1;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;

@Service
public class Business1 {

    private Logger logger = LoggerFactory.getLogger(this.getClass());

    private Dao1 dao1;

    @Autowired
    public void setDao1(Dao1 dao1) {
        this.dao1 = dao1;
    }

    public String runMethod(){
        return dao1.retrieveData();
    }
}
