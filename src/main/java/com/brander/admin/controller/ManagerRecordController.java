package com.brander.admin.controller;

import com.brander.common.domain.AdminTitle;
import com.brander.common.domain.FoManagerRecord;
import com.brander.common.service.FoManagerRecordService;
import com.brander.common.utils.AchieveUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.List;


/**
 * 管理员登录日志处理类
 */
@Controller
@RequestMapping(value = "/admin")
public class ManagerRecordController {

    @Autowired
    FoManagerRecordService foManagerRecordService;

    /**
    * 管理员登录日志列表页面
    * */
    @GetMapping(value = "/managerrecord/list")
    public String managerRecordList(ModelMap map){

        AdminTitle adminTitle = new AdminTitle();
        adminTitle.setTitle1("管理员登录日志");adminTitle.setTitle2("列表");
        map.addAttribute("adminTitle",adminTitle);

        List<FoManagerRecord> foManagerRecord = foManagerRecordService.selectJoinFoManager();
        map.addAttribute("foManagerRecord",foManagerRecord);

        long df = new java.util.Date().getTime();
        map.addAttribute("df", (long) AchieveUtil.getTimeStamp());

        return "admin/managerrecord/list";
    }


}
