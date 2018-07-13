package com.own.paper.util;

/**
 * @Author: zhaozhi
 * @Date: 2018/7/13 0013 13:52
 * @Description: 封装返回结果
 */
public class Result {
    private String result;
    private String msg;
    private Object data;

    public String getResult() {
        return result;
    }

    public void setResult(String result) {
        this.result = result;
    }

    public String getMsg() {
        return msg;
    }

    public void setMsg(String msg) {
        this.msg = msg;
    }

    public Object getData() {
        return data;
    }

    public void setData(Object data) {
        this.data = data;
    }

    @Override
    public String toString() {
        return "Result{" +
                "result='" + result + '\'' +
                ", msg='" + msg + '\'' +
                ", data=" + data +
                '}';
    }

    public Result(String[] code, Object data){
        this.result = code[0];
        this.msg = code[1];
        this.data = data;
    }

    public Result(String[] code){
        this.result = code[0];
        this.msg = code[1];
    }


}
