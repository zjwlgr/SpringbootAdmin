package com.brander.common.utils;


import com.brander.common.domain.Result;
import com.brander.common.enums.ResultEnum;


/**
 * 封装Result处理方法，主要用于API返回
 */
public class ResultUtil {

    /**
    * 成功要调用的方法，有Object参数
    * @param object
    * @return Result
    * */
    public static Result success(Object object){
        Result result = new Result();
        //使用枚举 code 0 , msg 成功
        ResultEnum resultEnum = ResultEnum.SUCCESS;
        result.setCode(resultEnum.getCode());
        result.setMsg(resultEnum.getMsg());
        result.setData(object);
        return result;
    }

    /**
    * 成功要调用的方法，重法重载，没有Object参数的
    * */
    public static Result success(){
        return success(null);
    }

    /**
    * 失败调用的方法
    * @param code 错误代码
    * @param msg 提示信息
    * @return Result
    * */
    public static Result error(Integer code, String msg){
        Result result = new Result();
        result.setCode(code);
        result.setMsg(msg);
        result.setData(null);
        return result;
    }
}
