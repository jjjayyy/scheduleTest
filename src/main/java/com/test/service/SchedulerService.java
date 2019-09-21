package com.test.service;

import com.test.vo.ScheduleVO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.concurrent.ThreadPoolTaskScheduler;
import org.springframework.scheduling.support.PeriodicTrigger;

import java.util.List;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.ScheduledFuture;
import java.util.concurrent.TimeUnit;

public class SchedulerService {
    //PeriodicTrigger periodicTrigger = new PeriodicTrigger(3, TimeUnit.SECONDS);

    @Autowired
    private ThreadPoolTaskScheduler taskScheduler;

    private Map<String, ScheduledFuture<?>> scheduledMap = new ConcurrentHashMap<>();

    public void startScheduler(List<ScheduleVO> scheduleList) throws InterruptedException {
   //         taskScheduler = new ThreadPoolTaskScheduler();

            for(ScheduleVO schedule : scheduleList) {
                registerScheduler(schedule);
            }
    }

    public void registerScheduler(ScheduleVO schedule) {
        taskScheduler.initialize();
        ScheduledFuture<?> task = taskScheduler.schedule(
                new RunnableTask(schedule.getMessage()),periodicTrigger(Integer.parseInt(schedule.getTimeTerm()))
        );
        scheduledMap.put(schedule.getSeq(), task);
    }
    public void stopScheduler(ScheduleVO scheduleVO) {
        scheduledMap.get(scheduleVO.getSeq()).cancel(true);
        scheduledMap.remove(scheduleVO.getSeq());
    }


    private PeriodicTrigger periodicTrigger(int timeTerm) {

        return new PeriodicTrigger(timeTerm, TimeUnit.SECONDS);
    }

}
