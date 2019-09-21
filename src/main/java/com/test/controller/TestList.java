package com.test.controller;

import com.test.service.RunnableTask;
import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.concurrent.ThreadPoolTaskScheduler;
import org.springframework.stereotype.Service;

import javax.annotation.PostConstruct;

@Service
public class TestList {

    @Autowired
    private SqlSession sqlSession;

    @Autowired
    private ThreadPoolTaskScheduler taskScheduler;

    @PostConstruct
    public void start() throws InterruptedException  {
//        SchedulerService schedulerService = new SchedulerService();
//        List<ScheduleVO> scheduleList = sqlSession.selectList("com.test.mapper.scheduleList");
//
//        schedulerService.startScheduler(scheduleList);

        taskScheduler.scheduleWithFixedDelay(
                new RunnableTask("Specific time, 3 Seconds from now"), 3000
        );

    }


}