package com.test.service;

import com.test.vo.ScheduleVO;
import org.springframework.scheduling.concurrent.ThreadPoolTaskScheduler;
import org.springframework.scheduling.support.PeriodicTrigger;

import java.util.concurrent.TimeUnit;

public class SchedulerService {
    //PeriodicTrigger periodicTrigger = new PeriodicTrigger(3, TimeUnit.SECONDS);
    private ThreadPoolTaskScheduler taskScheduler = new ThreadPoolTaskScheduler();

    public void startScheduler(ScheduleVO scheduleVO) {
        //taskScheduler = new ThreadPoolTaskScheduler();
        taskScheduler.initialize();
        taskScheduler.schedule(
            new RunnableTask(scheduleVO.getMessage()),periodicTrigger(Integer.parseInt(scheduleVO.getTimeTerm()))
        );
}
    public void stopScheduler() {
        taskScheduler.shutdown();
    }


    private PeriodicTrigger periodicTrigger(int timeTerm) {

        return new PeriodicTrigger(timeTerm, TimeUnit.SECONDS);
    }

}
