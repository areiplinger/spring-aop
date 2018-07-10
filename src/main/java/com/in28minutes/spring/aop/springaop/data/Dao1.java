package com.in28minutes.spring.aop.springaop.data;

import com.in28minutes.spring.aop.springaop.aspect.TrackTime;
import org.springframework.stereotype.Service;

@Service
public class Dao1 {

    @TrackTime
    public String retrieveSomething(){

        return "Dao1";

    }


}
