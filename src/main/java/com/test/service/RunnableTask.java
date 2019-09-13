package com.test.service;

import org.springframework.scheduling.support.CronTrigger;

import java.util.Date;

public class RunnableTask implements Runnable {
    private String message;
    private CronTrigger cronTrigger;

    public RunnableTask(String message){
        this.message = message;
    }

    public RunnableTask(String message, CronTrigger cronTrigger) {
        this.message = message;
        this.cronTrigger = cronTrigger;
    }

    @Override
    public void run() {
        System.out.println(new Date()+" Runnable Task with "+ message
                +" on thread "+Thread.currentThread().getName());
    }
}
