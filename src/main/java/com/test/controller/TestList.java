package com.test.controller;

import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.*;

@Controller
public class TestList {

    @Autowired
    private SqlSession sqlSession;

    @RequestMapping("/test")
    public void getList() throws Exception {
            String bb = "bb";
            List resultList = sqlSession.selectList("com.test.mapper.test");

            String aa = "aa";

    }

}
