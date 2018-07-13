package com.own.paper.service;

import javax.servlet.http.HttpSession;

/**
 * @Author: zhaozhi
 * @Date: 2018/7/13 9:41
 * @Description:
 */
public interface UserService {
    String login(String username, String password, HttpSession session);

    String register(String username, String password);
}
