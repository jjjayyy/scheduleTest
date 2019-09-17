package com.test.service;

import org.springframework.scheduling.support.CronTrigger;
import org.springframework.scheduling.support.PeriodicTrigger;

import java.util.Date;

public class RunnableTask implements Runnable {
    private String message;
    private CronTrigger cronTrigger;
    private PeriodicTrigger periodicTrigger;

    public RunnableTask(String message){
        this.message = message;
    }

    public RunnableTask(String message, CronTrigger cronTrigger) {
        this.message = message;
        this.cronTrigger = cronTrigger;
    }

    public RunnableTask(String message, PeriodicTrigger periodicTrigger) {
        this.message = message;
        this.periodicTrigger = periodicTrigger;
    }

    @Override
    public void run() {
        System.out.println(new Date()+" Runnable Task with "+ message
                +" on thread "+Thread.currentThread().getName());
    }
}
