package com.own.paper.util;

import com.alibaba.fastjson.JSON;

/**
 * @Author: zhaozhi
 * @Date: 2018/7/13 0013 14:07
 * @Description: 对结果对象进行操作
 */
public class ResultUtil {

    public static String getJsonString(String[] code){
        return JSON.toJSONString(new Result(code));
    }

    public static String getJsonString(String[] code,Object data){
        return JSON.toJSONString(new Result(code,data));
    }

}
