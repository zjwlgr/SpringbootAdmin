package com.brander.common.handle;

import com.brander.common.domain.FoFunction;
import com.brander.common.domain.FoManagerGroup;
import com.brander.common.domain.JsonResult;
import com.brander.common.enums.JsonResultEnum;
import com.brander.common.exception.JsonException;
import com.brander.common.service.FoFunctionService;
import com.brander.common.service.FoManagerGroupService;
import com.brander.common.utils.JsonResultUtil;
import com.brander.common.utils.MyArrayUtil;
import com.brander.common.utils.WebResultUtil;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import java.util.ArrayList;
import java.util.List;

/**
 * 异常捕获处理类
 */
// @ControllerAdvice是Spring 3.2新增的注解，
// 主要是用来Controller的一些公共的需求的低侵入性增强提供辅助，
// 作用于@RequestMapping标注的方法上。
@ControllerAdvice
public class MyControllerAdvice {

    //Logger是Spring自带的一个日志框架
    private final static Logger logger = LoggerFactory.getLogger(MyControllerAdvice.class);

    /**
    * 只处理自定义的异常JsonException
    * */
    @ExceptionHandler(value = JsonException.class)
    @ResponseBody
    public JsonResult girlHandle(Exception e){
        JsonException JsonException = (JsonException) e;
        return JsonResultUtil.error(JsonException.getCode(), JsonException.getMessage());
    }

    /**
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

    @Autowired
    FoFunctionService foFunctionService;

    @Autowired
    FoManagerGroupService foManagerGroupService;

    //应用到所有@RequestMapping注解方法，在其执行之前把返回值放入Model
    @ModelAttribute
    public void adminLeftList(HttpServletRequest request, ModelMap map) throws Exception {
        String uri = request.getRequestURI();
        if(uri.indexOf("/admin/") != -1){//如果为后台页面
            if(uri.indexOf("/admin/login") != -1 || uri.indexOf("/admin/kaptcha") != -1){
                //如果是后台登录页面或是后台验证码页面，不作任何处理
            }else{
                //查询用户所在的用户组对象
                FoManagerGroup foManagerGroup = foManagerGroupService.selectByPrimaryKey((int)(request.getSession().getAttribute("adminGroupid")));
                //得到用户组权限的FIDs与ZIDs
                List<FoFunction> foFid = new ArrayList<>();
                List<FoFunction> zoFid = new ArrayList<>();
                if(foManagerGroup.getFunction().equals("CJ")){
                    //超级管理员不作处理
                    foFid = null;zoFid = null;
                }else{
                    //得到用户组权限的FIDs
                    String fidin = foManagerGroup.getFunction().substring(0,foManagerGroup.getFunction().length()-1);
                    String [] fidArr = fidin.split(",");
                    for(String fids : fidArr){
                        FoFunction fidfo = new FoFunction();
                        fidfo.setFid(Integer.parseInt(fids));
                        foFid.add(fidfo);
                    }
                    //得到用户组权限的ZIDs
                    String idin = foManagerGroup.getChildtion().substring(0,foManagerGroup.getChildtion().length()-1);
                    String [] zidArr = idin.split(",");
                    for(String zids : zidArr){
                        FoFunction zdfo = new FoFunction();
                        zdfo.setId(Integer.parseInt(zids));
                        zoFid.add(zdfo);
                    }
                    //判断当前用是否有执行当前页面的权限
                    String nowuri = request.getRequestURI();
                    FoFunction foFunction = foFunctionService.selectByFuri(nowuri);
                    if(foFunction != null){//等于空的暂不处理
                        boolean isreque = MyArrayUtil.useLoop(zidArr,foFunction.getId().toString());
                        if(!isreque){
                            //您没有该页面的操作权限
                            throw new Exception("您没有该页面的操作权限");
                        }
                    }
                }
                //返回后台左侧功能列表
                List<FoFunction> foList = foFunctionService.selectByfid(0,true,null,foFid);
                for(FoFunction fo : foList){
                    fo.setClist(foFunctionService.selectByfid(fo.getId(),true,zoFid,null));
                }
                map.addAttribute("leftList",foList);
            }
        }
    }

    //应用到所有@RequestMapping注解方法，在其执行之前把返回值放入Model
    /*@ModelAttribute
    public String newUsers(HttpServletRequest request) {
        String uri = request.getRequestURI();
        System.out.println(uri);
        return "dfdsf";
    }*/

    /*@InitBinder
    public void initBinder(WebDataBinder binder) {
        System.out.println("============应用到所有@RequestMapping注解方法，在其执行之前初始化数据绑定器");
    }  */































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
