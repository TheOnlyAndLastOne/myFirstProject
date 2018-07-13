package com.own.paper.controller;

import com.own.paper.service.UserService;
import com.own.paper.util.Code;
import com.own.paper.util.ResultUtil;
import org.springframework.beans.factory.annotation.Autowired;

import javax.servlet.http.HttpSession;

/**
 * @Author zhaozhi
 * @Date 2018/7/13 9:39
 * @Description
 */
public class UserController {
    @Autowired
    private UserService userService;

    //用户注册
    public String register(String username, String password){
        return userService.register(username,password);
    }

    //用户登陆
    public String login(String username,String password,HttpSession session){
        return userService.login(username,password,session);
    }

    //用户登出
    public String logout(HttpSession session){
        session.removeAttribute("user");
        session.invalidate();
        return ResultUtil.getJsonString(Code.MSG_SUCCESS);
    }

}
