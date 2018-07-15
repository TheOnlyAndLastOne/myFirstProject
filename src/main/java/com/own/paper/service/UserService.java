package com.own.paper.service;

import javax.servlet.http.HttpSession;

/**
 * @Author: zhaozhi
 * @Date: 2018/7/13 9:41
 * @Description:
 */
public interface UserService {
    //用户登录
    String login(String username, String password, HttpSession session);

    //用户注册
    String register(String username, String password);

    //用户列表
    String userList();
}
