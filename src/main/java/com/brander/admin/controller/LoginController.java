package com.brander.admin.controller;

import com.brander.common.properties.MyConfigProperties;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * 管理员登录
 */
@Controller
@RequestMapping(value = "/admin")
public class LoginController {

    @Autowired
    MyConfigProperties myConfigProperties;

    @GetMapping(value = "/login")
    public String login(ModelMap map){



        map.addAttribute("myconfig",myConfigProperties);
        return "admin/login/index";
    }

}
