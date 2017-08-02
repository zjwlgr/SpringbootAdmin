package com.brander.index.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;

/**
 * 前台默认类
 */
@Controller
public class IndexController {

    @GetMapping(value = "/")
    public String index(ModelMap map){
        map.addAttribute("userphone", "13141437817");
        return "index/index/index";
    }

}
