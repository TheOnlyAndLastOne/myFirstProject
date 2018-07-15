package com.own.paper.dao;

import org.apache.ibatis.annotations.Select;

import java.util.List;
import java.util.Map;

public interface TestDao {
    @Select("select * from test")
    List<Map<String,Object>> test();
}
