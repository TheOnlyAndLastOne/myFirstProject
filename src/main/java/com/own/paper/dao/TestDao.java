package com.own.paper.dao;

import org.apache.ibatis.annotations.Select;

public interface TestDao {
    @Select("select * from test")
    String test();
}
