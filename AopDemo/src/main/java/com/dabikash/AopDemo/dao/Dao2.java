package com.dabikash.AopDemo.dao;

import org.springframework.stereotype.Repository;

@Repository
public class Dao2 {

    public String retrieveData(){
        return "dao2";
    }
}
