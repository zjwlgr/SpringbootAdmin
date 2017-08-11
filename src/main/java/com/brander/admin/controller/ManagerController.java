package com.brander.admin.controller;

import com.brander.common.domain.AdminTitle;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * 管理员处理类
 */
@Controller
@RequestMapping(value = "/admin")
public class ManagerController {

    /**
     * 管理员列表
     * */
    @GetMapping(value = "/manager/list")
    public String managerList(ModelMap map){

        AdminTitle adminTitle = new AdminTitle();
        adminTitle.setTitle1("管理员管理");adminTitle.setTitle2("列表");
        map.addAttribute("adminTitle",adminTitle);


        return "admin/manager/list";
    }

}
