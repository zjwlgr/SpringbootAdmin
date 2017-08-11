package com.brander.admin.controller;

import com.brander.common.domain.AdminTitle;
import com.brander.common.domain.FoManagerRecord;
import com.brander.common.service.FoManagerRecordService;
import com.brander.common.utils.AchieveUtil;
import com.brander.common.utils.PageUtil;
import com.github.pagehelper.PageInfo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
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
    public String managerRecordList(ModelMap map,FoManagerRecord fmr,HttpServletRequest request){

        AdminTitle adminTitle = new AdminTitle();
        adminTitle.setTitle1("管理员登录日志");adminTitle.setTitle2("列表");
        map.addAttribute("adminTitle",adminTitle);

        List<FoManagerRecord> foManagerRecord = foManagerRecordService.selectJoinFoManager(fmr);
        PageInfo pageInfo = new PageInfo<FoManagerRecord>(foManagerRecord);
        map.addAttribute("pageInfo",pageInfo);
        map.addAttribute("pageshow", PageUtil.show(pageInfo,request));

        return "admin/managerrecord/list";
    }

    /**
     * 删除管理员登录日志
     * */
    @GetMapping(value = "/managerrecord/delete")
    @ResponseBody
    public void managerRecordDelete(FoManagerRecord foManagerRecord, HttpServletResponse response) throws Exception{
        foManagerRecordService.deleteByPrimaryKey(foManagerRecord);
        response.sendRedirect("/admin/managerrecord/list");
    }


}
