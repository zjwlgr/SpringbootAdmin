package com.brander.index.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ResponseBody;

/**
 * 前台默认类
 */
@Controller
public class IndexController {

    @ResponseBody
    @GetMapping(value = "/")
    public String index(){
        return "index_controller";
    }

}
