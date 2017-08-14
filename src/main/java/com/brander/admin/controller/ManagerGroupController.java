package com.brander.admin.controller;

import com.brander.common.domain.AdminTitle;
import com.brander.common.domain.FoManager;
import com.brander.common.domain.FoManagerGroup;
import com.brander.common.service.FoManagerGroupService;
import com.brander.common.utils.PageUtil;
import com.github.pagehelper.PageInfo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.servlet.http.HttpServletRequest;
import java.util.List;

/**
 * 管理员分组类
 */
@Controller
@RequestMapping(value = "/admin")
public class ManagerGroupController {

    @Autowired
    FoManagerGroupService foManagerGroupService;

    @GetMapping(value = "/managergroup/list")
    public String managerGroupList(ModelMap map, HttpServletRequest request,FoManagerGroup fmg){
        AdminTitle adminTitle = new AdminTitle();
        adminTitle.setTitle1("管理员分组管理");
        adminTitle.setTitle2("列表");
        map.addAttribute("adminTitle", adminTitle);

        //管理员分组列表，分页
        List<FoManagerGroup> foManagerGroup = foManagerGroupService.selectByList(fmg);
        PageInfo pageInfo = new PageInfo<FoManagerGroup>(foManagerGroup);
        map.addAttribute("pageInfo",pageInfo);
        map.addAttribute("pageshow", PageUtil.show(pageInfo,request));

        return "admin/managergroup/list";
    }

}
