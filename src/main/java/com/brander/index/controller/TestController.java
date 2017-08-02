package com.brander.index.controller;

import com.brander.common.service.TestService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ResponseBody;

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

    /*
    * 测试系统Exception
    * */
    @GetMapping(value = "/test_system")
    @ResponseBody
    public String test_system(){
        double df = 1 / 0;
        return "hh";
    }

}
