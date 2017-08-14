package com.brander.admin.controller;

import com.brander.common.domain.AdminTitle;
import com.brander.common.domain.FoFunction;
import com.brander.common.domain.FoManager;
import com.brander.common.domain.FoManagerGroup;
import com.brander.common.service.FoFunctionService;
import com.brander.common.service.FoManagerGroupService;
import com.brander.common.utils.PageUtil;
import com.github.pagehelper.PageInfo;
import com.sun.org.apache.xpath.internal.operations.Mod;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.List;

/**
 * 管理员分组类
 */
@Controller
@RequestMapping(value = "/admin")
public class ManagerGroupController {

    @Autowired
    FoManagerGroupService foManagerGroupService;

    @Autowired
    FoFunctionService foFunctionService;

    /**
     * 管理员分组列表
     * */
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

    /**
     * 新增管理员分组
     * */
    @RequestMapping(value = "/managergroup/add")
    public String managerGroupAdd(ModelMap map, HttpServletRequest request, FoManagerGroup foManagerGroup){
        if(request.getMethod().equals("GET")) {
            AdminTitle adminTitle = new AdminTitle();
            adminTitle.setTitle1("管理员分组管理");
            adminTitle.setTitle2("新增");
            map.addAttribute("adminTitle", adminTitle);
            //管理员分组总数
            map.addAttribute("userGroupCount",foManagerGroupService.selectByCount());
            //功能列表
            List<FoFunction> foList = foFunctionService.selectByfid(0,true,null,null);
            for(FoFunction fo : foList){
                fo.setClist(foFunctionService.selectByfid(fo.getId(),true,null,null));
            }
            map.addAttribute("leftList",foList);
        }else if(request.getMethod().equals("POST")){
            String[] functionCheckbox= request.getParameterValues("function");
            String zid = "",fid = "";
            for(String str : functionCheckbox){
                String [] idArr = str.split("_");
                System.out.println("f"+idArr[0]);
                System.out.println("z"+idArr[1]);
                fid = fid + idArr[0]+",";
                zid = zid + idArr[1]+",";
            }
            System.out.println(fid);
            System.out.println(zid);
            //TODO 父与子功能 存为ID,ID。。w分两个字段，模板中用indexOf(ID,)匹配，对应用户权限功能列表当前方法可以，判断用户是否有权限 还是单一判断列表页也可以使用indexOf，参考php
        }
        return "admin/managergroup/add";
    }

    /**
     * 删除管理员分组操作
     * */
    @GetMapping(value = "/managergroup/del")
    public void managerGroupDel(FoManagerGroup foManagerGroup, HttpServletResponse response) throws Exception{
        foManagerGroupService.deleteByPrimaryKey(foManagerGroup);
        response.sendRedirect("/admin/managergroup/list");
    }
}
