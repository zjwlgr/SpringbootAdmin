package com.brander.common.utils;

import javax.servlet.http.HttpServletRequest;
import java.text.ParsePosition;
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
     * 获取访问者的浏览器与系统信息
     * @param request 当前请求
     * @param str browser@返回浏览器信息, system@返回系统信息
     * @return String 获得的浏览器与系统信息
     * */
    public static String getSystemBrowser(HttpServletRequest request,String str){
        String result = "";
        StringBuilder userAgent = new StringBuilder("[");
        userAgent.append(request.getHeader("User-Agent"));
        userAgent.append("]");
        int indexOfMac = userAgent.indexOf("Mac OS X");
        int indexOfWindows = userAgent.indexOf("Windows NT");
        int indexOfIE = userAgent.indexOf("MSIE");
        int indexOfIE11 = userAgent.indexOf("rv:");
        int indexOfFF = userAgent.indexOf("Firefox");
        int indexOfSogou = userAgent.indexOf("MetaSr");
        int indexOfChrome = userAgent.indexOf("Chrome");
        int indexOfSafari = userAgent.indexOf("Safari");
        boolean isMac = indexOfMac > 0;
        boolean isWindows = indexOfWindows > 0;
        boolean isLinux = userAgent.indexOf("Linux") > 0;
        boolean containIE = indexOfIE > 0 || (isWindows && (indexOfIE11 > 0));
        boolean containFF = indexOfFF > 0;
        boolean containSogou = indexOfSogou > 0;
        boolean containChrome = indexOfChrome > 0;
        boolean containSafari = indexOfSafari > 0;
        String browser = "";
        if (containSogou) {
            if (containIE) {
                browser = "搜狗" + userAgent.substring(indexOfIE, indexOfIE + "MSIE x.x".length());
            } else if (containChrome) {
                browser = "搜狗" + userAgent.substring(indexOfChrome, indexOfChrome + "Chrome/xx".length());
            }
        } else if (containChrome) {
            browser = userAgent.substring(indexOfChrome, indexOfChrome + "Chrome/xx".length());
        } else if (containSafari) {
            int indexOfSafariVersion = userAgent.indexOf("Version");
            browser = "Safari "
                    + userAgent.substring(indexOfSafariVersion, indexOfSafariVersion + "Version/x.x.x".length());
        } else if (containFF) {
            browser = userAgent.substring(indexOfFF, indexOfFF + "Firefox/xx".length());
        } else if (containIE) {
            if (indexOfIE11 > 0) {
                browser = "MSIE 11";
            } else {
                browser = userAgent.substring(indexOfIE, indexOfIE + "MSIE x.x".length());
            }
        }
        String system = "";
        if (isMac) {
            system = userAgent.substring(indexOfMac, indexOfMac + "MacOS X xxxx".length());
        } else if (isLinux) {
            system = "Linux";
        } else if (isWindows) {
            system = "Windows ";
            String version = userAgent.substring(indexOfWindows + "Windows NT".length(), indexOfWindows
                    + "Windows NTx.x".length());
            if ("5.0".equals(version.trim())) {
                system += "2000";
            } else if ("5.1".equals(version.trim())) {
                system += "XP";
            } else if ("5.2".equals(version.trim())) {
                system += "2003";
            } else if ("6.0".equals(version.trim())) {
                system += "Vista";
            } else if ("6.1".equals(version.trim())) {
                system += "7";
            } else if ("6.2".equals(version.trim())) {
                system += "8";
            } else if ("6.3".equals(version.trim())) {
                system += "8.1";
            }
        }
        if(str == "browser"){
            result = browser;
        }else if (str == "system"){
            result = system;
        }
        return result;
    }

    /**
     * 获取当前时间戳
     * @return Integer 转int类型的时间戳
     * */
    public static long getTimeStamp(){
        long timeStamp = System.currentTimeMillis(); //或者 new Date().getTime();
        //timeStamp = timeStamp / 1000;//去掉毫秒
        return timeStamp;
    }

    /**
     * 获取当前时间
     * @return String 字符串时间
     * */
    public static Date getDateTime(String pattern){
        if(pattern == null || pattern.length() == 0){
            pattern = "yyyy-MM-dd HH:mm:ss";
        }
        SimpleDateFormat sdf = new SimpleDateFormat(pattern);//设置日期格式
        String strDate = sdf.format(new Date());// new Date()为获取当前系统时间，也可使用当前时间戳
        ParsePosition pos = new ParsePosition(0);
        Date date = sdf.parse(strDate,pos);
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
