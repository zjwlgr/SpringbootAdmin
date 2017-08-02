package com.brander.common.handle;

import com.brander.common.domain.JsonResult;
import com.brander.common.exception.JsonException;
import com.brander.common.utils.JsonResultUtil;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;

/**
 * 异常捕获处理类
 */
// @ControllerAdvice是Spring 3.2新增的注解，
// 主要是用来Controller的一些公共的需求的低侵入性增强提供辅助，
// 作用于@RequestMapping标注的方法上。
@ControllerAdvice
public class ExceptionHandle {

    //Logger是Spring自带的一个日志框架
    private final static Logger logger = LoggerFactory.getLogger(ExceptionHandle.class);

    /*
    * 只处理自定义的异常JsonException
    * */
    @ExceptionHandler(value = JsonException.class)
    @ResponseBody
    public JsonResult girlHandle(Exception e){
        JsonException JsonException = (JsonException) e;
        return JsonResultUtil.error(JsonException.getCode(), JsonException.getMessage());
    }

    /*
    * 处理所有异常Exception
    * */
    @ExceptionHandler(value = Exception.class)
    public ModelAndView allHandle(HttpServletRequest req, Exception e){
        ModelAndView mav = new ModelAndView();
        mav.addObject("exception", e);
        mav.addObject("url", req.getRequestURL());
        mav.setViewName("pages/exception");
        return mav;
    }








    /*
    * 捕获异常的方法，可以写多个，比如自定义为一个只处理api的，另一个是处理所有异常的
    * @ExceptionHandler 捕获异常注解
    * value的值代表你要处理哪些异常，可以是所有异常也可以只处理自定义的异常
    * */
    /*@ExceptionHandler(value = Exception.class)
    @ResponseBody
    public Result handle(Exception e){
        if (e instanceof JsonException) {//判断捕获的是不是自己定义的异常类

            //如果是，将当前异常强转为JsonException自己的异常类型,,,e为自己的异常类
            JsonException JsonException = (JsonException) e;

            //e == JsonException在Service已被实例化，被捕获过来，所以可调用该类中的方法
            return ResultUtil.error(JsonException.getCode(), JsonException.getMessage());
            //.getMessage()为调用父类Exception的方法
            //调用统一异常管理方法

        }else {//如果是系统抛出的异常

            logger.error("【系统异常】{}", e);//打印日志，方便调试，在控制台打印错误日志

            //使用枚举 code -1 , msg 未知错误
            ResultEnum resultEnum = ResultEnum.UNKONW_ERROR;

            return ResultUtil.error(resultEnum.getCode(), e.getMessage());//调用统一异常管理方法
        }
    }*/
    /*   作用于@RequestMapping标注的方法上
         @ExceptionHandler 捕获异常注解
         所以发生在controller中的异常会被捕获
     */

}
