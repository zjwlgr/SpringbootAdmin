package com.brander.admin.controller;

/**
 * 后台首页
 */

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping(value = "/admin")
public class DefaultController {

    @GetMapping(value = "/index")
    public String index(){

        return "admin/index/index";
    }
}
