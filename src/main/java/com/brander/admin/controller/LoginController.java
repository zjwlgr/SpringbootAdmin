package com.brander.admin.controller;

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

    @GetMapping(value = "/login")
    public String login(ModelMap map){
        SimpleDateFormat df = new SimpleDateFormat("yyyy");
        String year = df.format(new Date());
        map.addAttribute("year",year);
        return "admin/login/index";
    }

}
