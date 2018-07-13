package com.own.paper.service.impl;

import com.own.paper.dao.UserDao;
import com.own.paper.entity.User;
import com.own.paper.service.UserService;
import com.own.paper.util.Code;
import com.own.paper.util.MD5Util;
import com.own.paper.util.ResultUtil;
import org.springframework.beans.factory.annotation.Autowired;

import javax.servlet.http.HttpSession;

/**
 * @Author: zhaozhi
 * @Date: 2018/7/13 9:47
 * @Description:
 */
public class UserServiceImpl implements UserService {
    @Autowired
    private UserDao userDao;

    @Override
    public String login(String username, String password, HttpSession session) {
        //根据用户名去数据库查询
        User user = userDao.getPasswordByName(username);

        if(null == user){
            return ResultUtil.getJsonString(Code.MSG_USER_OR_PASSWORD_WRONG);
        }

        //密码验证
        String dataPass = user.getPassword();
        boolean bol = MD5Util.verify(password,dataPass);
        if(!bol){
            return ResultUtil.getJsonString(Code.MSG_USER_OR_PASSWORD_WRONG);
        }

        session.setAttribute("user",user);

        return ResultUtil.getJsonString(Code.MSG_SUCCESS);
    }

    @Override
    public String register(String username, String password) {
        String md5Pass = MD5Util.MD5Salt(password);
        userDao.addUser(username,md5Pass);
        return ResultUtil.getJsonString(Code.MSG_SUCCESS);
    }
}
