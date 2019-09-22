package com.test.service;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.scheduling.annotation.EnableAsync;
import org.springframework.scheduling.concurrent.ThreadPoolTaskScheduler;

@Configuration
@EnableAsync
public class ThreadPoolTaskSchedulerConfig {

    @Bean
    public ThreadPoolTaskScheduler threadPoolTaskScheduler() {
        ThreadPoolTaskScheduler taskScheduler = new ThreadPoolTaskScheduler();
        taskScheduler.setPoolSize(5);
        taskScheduler.setThreadNamePrefix("timeSchedule");
        taskScheduler.initialize();
        //taskScheduler.setRejectedExecutionHandler(new ThreadPoolExecutor.AbortPolicy());
        return taskScheduler;
    }
}
