package com.brander.common.exception;

import com.brander.common.enums.JsonResultEnum;

/**
 * 创建自己的Exception类，主要用于json返回
 */

//必须继承RuntimeException，spring框架才能回滚异常
public class JsonException extends RuntimeException {

    private Integer code;

    public JsonException(JsonResultEnum jsonResultEnum) {
        super(jsonResultEnum.getMsg());//调用父类的构造方法，将msg传给父类，父类就可以打印这个msg
        this.code = jsonResultEnum.getCode();//为code赋值
    }

    public Integer getCode() {
        return code;
    }

    public void setCode(Integer code) {
        this.code = code;
    }
}
