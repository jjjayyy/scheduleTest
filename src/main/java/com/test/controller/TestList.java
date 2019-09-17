package com.test.controller;

import com.test.service.SchedulerService;
import com.test.vo.ScheduleVO;
import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.annotation.PostConstruct;
import java.util.List;

@Controller
public class TestList {

    @Autowired
    private SqlSession sqlSession;

    @Autowired
    private SchedulerService schedulerService;

    @RequestMapping("/test")
    public void getList() throws Exception {

            String bb = "bb";
            List resultList = sqlSession.selectList("com.test.mapper.test");
            List<ScheduleVO> scheduleList = sqlSession.selectList("com.test.mapper.scheduleList");

            String aa = "aa";

    }

    @PostConstruct
    public void start() throws InterruptedException  {
        List<ScheduleVO> scheduleList = sqlSession.selectList("com.test.mapper.scheduleList");

        for(ScheduleVO scheduleVO : scheduleList) {
            schedulerService.startScheduler(scheduleVO);
        }
        //Thread.sleep(10000);
    }
}