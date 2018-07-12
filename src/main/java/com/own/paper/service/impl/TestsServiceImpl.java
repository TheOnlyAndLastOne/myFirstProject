package com.own.paper.service.impl;

import com.own.paper.dao.TestDao;
import com.own.paper.service.TestService;
import org.springframework.beans.factory.annotation.Autowired;

public class TestsServiceImpl implements TestService {
    @Autowired
    private TestDao testDao;

    @Override
    public String test() {
       return  testDao.test();
    }
}
