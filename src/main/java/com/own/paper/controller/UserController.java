package com.own.paper.controller;

import com.own.paper.service.UserService;
import com.own.paper.util.Code;
import com.own.paper.util.ResultUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpSession;

/**
 * @Author zhaozhi
 * @Date 2018/7/13 9:39
 * @Description
 */
@RestController
public class UserController {
    @Autowired
    private UserService userService;

    //用户注册
    @RequestMapping(value = "/register",produces = "application/json;charset=utf-8")
    public String register(String username, String password){
        return userService.register(username,password);
    }

    //用户登陆
    @RequestMapping(value = "/login",produces = "application/json;charset=utf-8")
    public String login(String username,String password,HttpSession session){
        return userService.login(username,password,session);
    }

    //用户列表
    @RequestMapping(value = "/userList",produces = "application/json;charset=utf-8")
    public String userList(){
        return userService.userList();
    }

    //用户登出
    @RequestMapping(value = "/logout",produces = "application/json;charset=utf-8")
    public String logout(HttpSession session){
        session.removeAttribute("user");
        session.invalidate();
        return ResultUtil.getJsonString(Code.MSG_SUCCESS);
    }

}
