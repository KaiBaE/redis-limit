package com.example.list;


import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;



@RestController
public class cont {

    @Resource
    Action action;

    @GetMapping("/action")
    public void bussiness(){
        action.action();
    }

}
