package com.test.controller;

import com.test.service.RunnableTask;
import com.test.service.ThreadPoolTaskSchedulerConfig;
import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.scheduling.concurrent.ThreadPoolTaskScheduler;
import org.springframework.scheduling.support.CronTrigger;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.annotation.PostConstruct;
import java.time.LocalDateTime;
import java.util.*;

@Controller
public class TestList {

    @Autowired
    private SqlSession sqlSession;

    @RequestMapping("/test")
    public void getList() throws Exception {

            String bb = "bb";
            List resultList = sqlSession.selectList("com.test.mapper.test");
            String aa = "aa";

    }

//    @Scheduled(cron="0/3 * * * * *")
//    public void schedule() {
//        System.out.println(LocalDateTime.now());
//    }

    @PostConstruct
    public void startScheduler() {

        ThreadPoolTaskScheduler taskScheduler = new ThreadPoolTaskScheduler();
        for(int i=0; i<10; i++) {
            taskScheduler.initialize();
            taskScheduler.schedule(
//                new RunnableTask("Specific time, 3 Seconds from now"),
//                new Date(System.currentTimeMillis() + 3000)
                    new RunnableTask("Cron Trigger"), new CronTrigger("0/3 * * * * *")
            );
        }



        ThreadPoolTaskScheduler taskScheduler2 = new ThreadPoolTaskScheduler();
        taskScheduler2.initialize();
        taskScheduler2.schedule(
                new RunnableTask("Cron Trigger222"), new CronTrigger("0/5 * * * * *")
        );

    }
}
