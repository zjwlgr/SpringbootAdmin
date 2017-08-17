package com.brander.admin.controller;

import com.brander.common.domain.AdminTitle;
import com.brander.common.domain.FoClass;
import com.brander.common.service.FoClassService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

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

    /**
     * Ajax 添加分类
     * */
    @PostMapping(value = "/class/add")
    public String classAdd(FoClass foClass,ModelMap map){
        foClass.setDepth(foClass.getDepth() + 1);
        foClass.setNexus("");
        if(foClass.getDepth() > 1){
            foClass.setNexus(foClass.getFid()+",");
        }
        foClassService.insertSelective(foClass);
        foClass.setSort(0);
        foClass.setZcount(0);
        map.addAttribute("vo",foClass);
        return "admin/class/add";
    }

    /**
     * Ajax 编辑分类
     * */
    @PostMapping(value = "/class/up")
    @ResponseBody
    public int classUp(FoClass foClass){
        return foClassService.updateByPrimaryKeySelective(foClass);
    }

    /**
     * Ajax 展开分类
     * */
    @PostMapping(value = "/class/updown")
    public String classUpdown(FoClass foClass,ModelMap map){
        //返回当前ID下的子分类列表
        map.addAttribute("classList",foClassService.selectByfid(foClass.getId(),true));
        //返回当前ID对应分类对象
        map.addAttribute("classone",foClassService.selectByPrimaryKey(foClass.getId()));
        return "admin/class/updown";
    }

    /**
     * AJAX 删除分类
     * */
    @PostMapping(value = "/class/delete")
    @ResponseBody
    public int classDelete(FoClass foClass){
        foClassService.deleteByPrimaryKey(foClass.getId());
        return foClassService.deleteByNexus(foClass.getId());
    }

}
