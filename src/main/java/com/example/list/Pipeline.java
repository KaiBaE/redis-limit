package com.example.list;

import org.springframework.data.redis.core.StringRedisTemplate;
import org.springframework.scheduling.annotation.EnableScheduling;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

import javax.annotation.Resource;
import java.util.ArrayList;
import java.util.List;

@Component
@EnableScheduling
public class Pipeline {

    long listSize = 1000;

    @Resource
    StringRedisTemplate stringRedisTemplate;

    //  每秒将list添满
    @Scheduled(cron = "0/1 * * * * ?")
    public void pushFull(){
        Long size = stringRedisTemplate.opsForList().size("l1");
        if(size==listSize)return ;
        List list = new ArrayList();
        while(size<listSize){
            list.add("1");
            size++;
        }
        stringRedisTemplate.opsForList().rightPushAll("l1", list);
    }

    //  判断是否还有余量
    public boolean canVisit(){
        return stringRedisTemplate.opsForList().leftPop("l1")==null ? false:true;
    }

}
