package com.own.paper.dao;

import com.own.paper.entity.User;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;

/**
 * @Author: zhaozhi
 * @Date: 2018/7/13 9:48
 * @Description:
 */
public interface UserDao {

    //根据用户名查询用户信息
    @Select("select * from user where userName = #{username}")
    User getPasswordByName(@Param("username") String username);

    @Insert("insert into user (userName,password) values (#{username},#{password})")
    void addUser(@Param("username") String username, @Param("password") String password);
}
