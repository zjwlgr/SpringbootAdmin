package com.brander.admin.controller;

import com.brander.common.domain.AdminTitle;
import com.brander.common.domain.FoClass;
import com.brander.common.service.FoClassService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * 无限级分类处理类
 */
@Controller
@RequestMapping(value = "/admin")
public class ClassController {

    @Autowired
    FoClassService foClassService;

    /**
     * 分类列表页
     * */
    @GetMapping(value = "/class/list")
    public String classList(ModelMap map){
        AdminTitle adminTitle = new AdminTitle();
        adminTitle.setTitle1("系统分类管理");
        map.addAttribute("adminTitle",adminTitle);
        //返回fid=0的最顶层分类列表
        map.addAttribute("classList",foClassService.selectByfid(0,true));
        //返回fid=0的最顶层分类列表总数
        map.addAttribute("classCount",foClassService.selectFidCount(0));
        return "admin/class/list";
    }

}
