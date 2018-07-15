package com.own.paper.service.impl;

import com.own.paper.dao.UserDao;
import com.own.paper.entity.User;
import com.own.paper.service.UserService;
import com.own.paper.util.Code;
import com.own.paper.util.MD5Util;
import com.own.paper.util.ResultUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.servlet.http.HttpSession;
import java.util.List;
import java.util.Map;

/**
 * @Author: zhaozhi
 * @Date: 2018/7/13 9:47
 * @Description:
 */

@Service
@Transactional
public class UserServiceImpl implements UserService {
    @Autowired
    private UserDao userDao;

    //用户登录
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

    //用户注册
    @Override
    public String register(String username, String password) {
        String md5Pass = MD5Util.MD5Salt(password);
        userDao.addUser(username,md5Pass);
        return ResultUtil.getJsonString(Code.MSG_SUCCESS);
    }

    //用户列表
    @Override
    public String userList() {
        List<Map<String,Object>> list = userDao.userList();
        return ResultUtil.getJsonString(Code.MSG_SUCCESS,list);
    }
}
