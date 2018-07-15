package com.own.paper.service.impl;

import com.alibaba.fastjson.JSON;
import com.own.paper.dao.TestDao;
import com.own.paper.service.TestService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Map;

@Service
@Transactional
public class TestsServiceImpl implements TestService {
    @Autowired
    private TestDao testDao;

    @Override
    public String test() {
        List<Map<String,Object>> list = testDao.test();
        return JSON.toJSONString(list);
    }
}
