package com.brander.common.utils;

import org.springframework.ui.ModelMap;

/**
 * 处理在系统逻辑中，用户在操作后的成功或失败的提示页面，自动跳转到对应页面
 */
public class WebResultUtil {

    /**
     * 成功跳转提示
     * @param map 于Controller中传过来的map对象
     * @param message 成功提示语
     * @param url 需跳转到的URL
     * */
    public static String success(ModelMap map, String message, String url){
        map.addAttribute("message",message);
        map.addAttribute("url",url);
        map.addAttribute("wait",2);
        map.addAttribute("type","success");
        return "pages/dispatch_jump";
    }

    /**
     * 失败跳转提示
     * @param map 于Controller中传过来的map对象
     * @param message 失败提示语
     * @param url 需跳转到的URL
     * */
    public static String error(ModelMap map, String message, String url){
        map.addAttribute("message",message);
        map.addAttribute("url",url);
        map.addAttribute("wait",4);
        map.addAttribute("type","error");
        return "pages/dispatch_jump";
    }

    //使用
    //return WebResultUtil.success(map,"管理员删除成功！","/admin/manager/list");
}
