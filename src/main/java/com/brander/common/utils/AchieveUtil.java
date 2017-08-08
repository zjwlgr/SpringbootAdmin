package com.brander.common.utils;

import javax.servlet.http.HttpServletRequest;
import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * 各种获取工具类
 */
public class AchieveUtil {

    /**
     * 获取访问者IP地址，包括被反向代理的
     * @param request 当前请求
     * @return String 获得的IP地址
     * */
    public static String getIpAddr(HttpServletRequest request) {
        String ip = request.getHeader("x-forwarded-for");
        if(null == ip || 0 == ip.length() || "unknown".equalsIgnoreCase(ip)) {
            ip = request.getHeader("Proxy-Client-IP");
        }
        if(null == ip || 0 == ip.length() || "unknown".equalsIgnoreCase(ip)) {
            ip = request.getHeader("WL-Proxy-Client-IP");
        }
        if(null == ip || 0 == ip.length() || "unknown".equalsIgnoreCase(ip)) {
            ip = request.getHeader("X-Real-IP");
        }
        if(null == ip || 0 == ip.length() || "unknown".equalsIgnoreCase(ip)) {
            ip = request.getRemoteAddr();
        }
        return ip;
    }

    /**
     * 获取当前时间戳
     * @return Integer 转int类型的时间戳
     * */
    public static Integer getTimeStamp(){
        long timeStamp = System.currentTimeMillis(); //或者 new Date().getTime();
        timeStamp = timeStamp / 1000;//去掉毫秒
        return (int)timeStamp;//返回int类型
    }

    /**
     * 获取当前时间
     * @return String 字符串时间
     * */
    public static String getTime(String pattern){
        if(pattern == null || pattern.length() == 0){
            pattern = "yyyy-MM-dd HH:mm:ss";
        }
        SimpleDateFormat df = new SimpleDateFormat(pattern);//设置日期格式
        String date = df.format(new Date());// new Date()为获取当前系统时间，也可使用当前时间戳
        return date;
    }

    /**
     * 获取当前请求的URL地址，不包括？号后面的参数
     * @param request 当前请求
     * @return String 获得的URL
     * */
    public static String getUrl(HttpServletRequest request){
        return request.getRequestURL().toString();
    }

    /**
     * 获取当前请求的URL中域名后面的部分，包括/
     * @param request 当前请求
     * @return String 获得的URI
     * */
    public static String getUri(HttpServletRequest request){
        return request.getRequestURI();
    }

    /**
     * 得到请求的URL地址中附带的参数，？号后面的部分，不包括？号
     * @param request 当前请求
     * @return String 获得的参数字符串
    * */
    public static String getParam(HttpServletRequest request){
        return request.getQueryString();
    }

    /**
     * 得到请求URL的请求类型，GET，POST...
     * @param request 当前请求
     * @return String 获得的请求类型
     * */
    public static String getMethod(HttpServletRequest request){
        return request.getMethod();
    }

    /**
     * 获取WEB服务器的IP地址
     * @param request 当前请求
     * @return String 获得的服务器IP地址
     * */
    public static String getServerIp(HttpServletRequest request){
        return request.getLocalAddr();
    }

    /**
     * 获取WEB服务器的主机名
     * @param request 当前请求
     * @return String 获得的服务器主机名
     * */
    public static String getServerName(HttpServletRequest request){
        return request.getLocalName();
    }

}
