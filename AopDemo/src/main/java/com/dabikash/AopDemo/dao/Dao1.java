package com.dabikash.AopDemo.dao;

import com.dabikash.AopDemo.aspects.TrackTime;
import org.springframework.stereotype.Repository;

@Repository
public class Dao1 {

    @TrackTime
    public String retrieveData(){
        return "dao1";
    }
}
