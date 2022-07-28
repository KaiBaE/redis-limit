package com.example.list;

import org.springframework.stereotype.Service;

import javax.annotation.Resource;

@Service
public class Action {

    @Resource
    Pipeline pipeline;

    public void action(){
        if(pipeline.canVisit()){
            //   业务
        }
    }

}
