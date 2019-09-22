package com.test.service;

import com.test.vo.ScheduleVO;
import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.concurrent.ThreadPoolTaskScheduler;
import org.springframework.scheduling.support.PeriodicTrigger;
import org.springframework.stereotype.Component;

import java.util.Date;
import java.util.List;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.ScheduledFuture;
import java.util.concurrent.TimeUnit;

@Component
public class SchedulerService {

    @Autowired
    private ThreadPoolTaskScheduler threadPoolTaskScheduler;

    @Autowired
    private SqlSession sqlSession;

    private Map<String, ScheduledFuture<?>> scheduledMap = new ConcurrentHashMap<>();

    public void startScheduler(List<ScheduleVO> scheduleList) throws InterruptedException {

            for(ScheduleVO schedule : scheduleList) {
                registerScheduler(schedule);
            }
    }

    public void registerScheduler(ScheduleVO schedule) {

        ScheduledFuture<?> task = threadPoolTaskScheduler.schedule(

                () -> {
                    List<ScheduleVO> scheduleList = sqlSession.selectList("com.test.mapper.scheduleList");

                    System.out.println(new Date()+" Runnable Task with "+ schedule.getMessage()
                            +" on thread "+Thread.currentThread().getName());
                }, periodicTrigger(Integer.parseInt(schedule.getTimeTerm()))

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
