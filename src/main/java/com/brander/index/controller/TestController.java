package com.brander.index.controller;

import com.brander.common.service.TestService;
import com.brander.common.utils.AchieveUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.util.DigestUtils;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpServletRequest;
import java.util.Date;

/**
 * 测试类
 */
@Controller
public class TestController {

    @Autowired
    private TestService testService;

    /*
    * 测试自定义Exception
    * */
    @GetMapping(value = "/test_result")
    public String text_result() throws Exception{
        testService.testResult(10);
        return " cy ";
    }


    @GetMapping(value = "/test_system")
    @ResponseBody
    public String test_system(HttpServletRequest request){
        Date str = AchieveUtil.getDateTime("yyyy-MM-dd HH:mm:ss");
        String url = AchieveUtil.getUrl(request);
        String uri = AchieveUtil.getUri(request);
        String param = AchieveUtil.getParam(request);
        String method = AchieveUtil.getMethod(request);
        String serverip = AchieveUtil.getServerIp(request);
        String servername = AchieveUtil.getServerName(request);
        return str + url + uri + param + method + serverip + servername;
    }


    @GetMapping(value = "/test_sys")
    @ResponseBody
    public String test_sys(HttpServletRequest request) {
        return "";
    }

}
