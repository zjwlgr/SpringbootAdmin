package com.brander.common.domain;

/**
 * HTTP 请求返回的最外层对象
 */
public class JsonResult<T> {  //这个泛型 T 代标所有类型 。。。。

    //错误代码
    private Integer code;

    //提示信息
    private String msg;

    //具体内容
    private Object data;
    //private T data;

    public Integer getCode() {
        return code;
    }

    public void setCode(Integer code) {
        this.code = code;
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
}
