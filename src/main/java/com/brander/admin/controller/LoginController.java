package com.brander.admin.controller;

import com.brander.common.properties.MyConfigProperties;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * 管理员登录
 */
@Controller
@RequestMapping(value = "/admin")
public class LoginController {


    @GetMapping(value = "/login")
    public String login(){

        return "admin/login/index";
    }

}
