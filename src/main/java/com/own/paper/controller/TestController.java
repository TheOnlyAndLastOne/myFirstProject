package com.own.paper.controller;

import com.own.paper.service.TestService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class TestController {
    @Autowired
    private TestService testService;

    public String test(){
        return testService.test();
    }
}
