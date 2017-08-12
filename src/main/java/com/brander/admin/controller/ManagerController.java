package com.brander.admin.controller;

import com.brander.common.domain.AdminTitle;
import com.brander.common.domain.FoManager;
import com.brander.common.domain.FoManagerGroup;
import com.brander.common.domain.FoManagerRecord;
import com.brander.common.service.FoManagerGroupService;
import com.brander.common.service.FoManagerService;
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
 * 管理员处理类
 */
@Controller
@RequestMapping(value = "/admin")
public class ManagerController {

    @Autowired
    FoManagerService foManagerService;

    @Autowired
    FoManagerGroupService foManagerGroupService;

    /**
     * 管理员列表
     * */
    @GetMapping(value = "/manager/list")
    public String managerList(ModelMap map, FoManager fmr, HttpServletRequest request){

        AdminTitle adminTitle = new AdminTitle();
        adminTitle.setTitle1("管理员管理");adminTitle.setTitle2("列表");
        map.addAttribute("adminTitle",adminTitle);

        List<FoManager> foManager = foManagerService.selectByList(fmr);
        PageInfo pageInfo = new PageInfo<FoManager>(foManager);
        map.addAttribute("pageInfo",pageInfo);
        map.addAttribute("pageshow", PageUtil.show(pageInfo,request));
        map.addAttribute("groupList",foManagerGroupService.selectByList(""));
//TODO 加个状态筛选
        return "admin/manager/list";
    }

}
