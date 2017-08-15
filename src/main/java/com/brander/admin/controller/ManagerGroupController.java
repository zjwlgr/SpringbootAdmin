package com.brander.admin.controller;

import com.brander.common.domain.AdminTitle;
import com.brander.common.domain.FoFunction;
import com.brander.common.domain.FoManagerGroup;
import com.brander.common.service.FoFunctionService;
import com.brander.common.service.FoManagerGroupService;
import com.brander.common.utils.*;
import com.github.pagehelper.PageInfo;
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
            //父与子功能 存为ID,ID。。w分两个字段
            foManagerGroup.setFunction(AdminUtil.managerGroupCheckbox(functionCheckbox,"fid"));
            foManagerGroup.setChildtion(AdminUtil.managerGroupCheckbox(functionCheckbox,"zid"));
            foManagerGroup.setCtime(AchieveUtil.getDateTime(""));
            foManagerGroupService.insertSelective(foManagerGroup);
            return WebResultUtil.success(map,"管理员分组新增成功！","/admin/managergroup/list");
        }
        return "admin/managergroup/add";
    }

    /**
     * 编辑管理员分组
     * */
    @RequestMapping(value = "/managergroup/up")
    public String managerGroupUp(ModelMap map, HttpServletRequest request, FoManagerGroup foManagerGroup){
        if(request.getMethod().equals("GET")) {
            AdminTitle adminTitle = new AdminTitle();
            adminTitle.setTitle1("管理员分组管理");
            adminTitle.setTitle2("编辑");
            map.addAttribute("adminTitle", adminTitle);
            //得到当前ID的分组对象
            map.addAttribute("groupInfo",foManagerGroupService.selectByPrimaryKey(foManagerGroup.getId()));
            //管理员分组总数
            map.addAttribute("userGroupCount",foManagerGroupService.selectByCount());
            //功能列表
            List<FoFunction> foList = foFunctionService.selectByfid(0,true,null,null);
            for(FoFunction fo : foList){
                fo.setClist(foFunctionService.selectByfid(fo.getId(),true,null,null));
            }
            map.addAttribute("leftList",foList);
        }else if(request.getMethod().equals("POST")) {
            String[] functionCheckbox = request.getParameterValues("function");
            //父与子功能 存为ID,ID。。w分两个字段
            foManagerGroup.setFunction(AdminUtil.managerGroupCheckbox(functionCheckbox,"fid"));
            foManagerGroup.setChildtion(AdminUtil.managerGroupCheckbox(functionCheckbox,"zid"));
            foManagerGroup.setCtime(AchieveUtil.getDateTime(""));
            foManagerGroupService.updateByPrimaryKeySelective(foManagerGroup);
            return WebResultUtil.success(map,"管理员分组编辑成功！","/admin/managergroup/list");
        }
        return "admin/managergroup/up";
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
