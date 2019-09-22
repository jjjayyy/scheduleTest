package com.test.controller;

import com.test.service.SchedulerService;
import com.test.vo.ScheduleVO;
import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.concurrent.ThreadPoolTaskScheduler;
import org.springframework.stereotype.Service;

import javax.annotation.PostConstruct;
import java.util.List;

@Service
public class TestList {

    @Autowired
    private SqlSession sqlSession;

    @Autowired
    private ThreadPoolTaskScheduler threadPoolTaskScheduler;

    @Autowired
    private SchedulerService schedulerService;

    @PostConstruct
    public void start() throws Exception {
        List<ScheduleVO> scheduleList = sqlSession.selectList("com.test.mapper.scheduleList");

        schedulerService.startScheduler(scheduleList);

    }




}