package com.test.service;

import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.support.CronTrigger;
import org.springframework.scheduling.support.PeriodicTrigger;

import java.util.Date;

public class RunnableTask implements Runnable {
    private String message;
    private CronTrigger cronTrigger;
    private PeriodicTrigger periodicTrigger;

    @Autowired
    private SqlSession sqlSession;

    public RunnableTask(String message) {
        this.message = message;
    }

    public RunnableTask(String message, PeriodicTrigger periodicTrigger) {
        this.message = message;
        this.periodicTrigger = periodicTrigger;
    }

    @Override
    public void run() {

//        List<ScheduleVO> scheduleList = sqlSession.selectList("com.test.mapper.scheduleList");

//        System.out.printf(scheduleList.get(0).getMessage());

        System.out.println(new Date()+" Runnable Task with "+ message
                +" on thread "+Thread.currentThread().getName());
    }


}
