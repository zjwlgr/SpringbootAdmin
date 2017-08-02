package com.brander.common.utils;


import com.brander.common.domain.JsonResult;
import com.brander.common.enums.JsonResultEnum;


/**
 * 封装Result处理方法，主要用于API返回
 */
public class JsonResultUtil {

    /**
    * 成功要调用的方法，有Object参数
    * @param object
    * @return Result
    * */
    public static JsonResult success(Object object){
        JsonResult jsonResult = new JsonResult();
        //使用枚举 code 0 , msg 成功
        JsonResultEnum jsonResultEnum = JsonResultEnum.SUCCESS;
        jsonResult.setCode(jsonResultEnum.getCode());
        jsonResult.setMsg(jsonResultEnum.getMsg());
        jsonResult.setData(object);
        return jsonResult;
    }

    /**
    * 成功要调用的方法，重法重载，没有Object参数的
    * */
    public static JsonResult success(){
        return success(null);
    }

    /**
    * 失败调用的方法
    * @param code 错误代码
    * @param msg 提示信息
    * @return Result
    * */
    public static JsonResult error(Integer code, String msg){
        JsonResult jsonResult = new JsonResult();
        jsonResult.setCode(code);
        jsonResult.setMsg(msg);
        jsonResult.setData(null);
        return jsonResult;
    }
}
