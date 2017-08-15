package com.brander.admin.controller;

import com.brander.common.domain.AdminTitle;
import com.brander.common.domain.FoFunction;
import com.brander.common.domain.FoManager;
import com.brander.common.service.FoFunctionService;
import com.brander.common.utils.WebResultUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.List;

/**
 * 功能管理类
 */
@Controller
@RequestMapping(value = "/admin")
public class FunctionController {

    @Autowired
    FoFunctionService foFunctionService;

    /**
     * 功能管理列表
     * */
    @GetMapping(value = "/function/list")
    public String functionList(ModelMap map){
        AdminTitle adminTitle = new AdminTitle();
        adminTitle.setTitle1("系统功能管理");adminTitle.setTitle2("列表");
        map.addAttribute("adminTitle",adminTitle);

        //功能列表
        List<FoFunction> functionList = foFunctionService.selectByfid(0,false,null,null);
        for(FoFunction fo : functionList){
            //查询该fid下面的子功能数量
            fo.setChildfocount(foFunctionService.selectCidCount(fo.getId()));
            //循环嵌套子功能列表
            fo.setClist(foFunctionService.selectByfid(fo.getId(),false,null,null));
        }
        map.addAttribute("functionList",functionList);

        return "admin/function/list";
    }

    /**
     * 添加功能
     * */
    @RequestMapping(value = "/function/add")
    public String functionAdd(ModelMap map, FoFunction foFunction, HttpServletRequest request){
        if(request.getMethod().equals("GET")) {
            AdminTitle adminTitle = new AdminTitle();
            adminTitle.setTitle1("系统功能管理");adminTitle.setTitle2("新增");
            map.addAttribute("adminTitle", adminTitle);
            //返回父功能列表
            map.addAttribute("FfuncList",foFunctionService.selectByfid(0,false,null,null));

        }else if(request.getMethod().equals("POST")){
            int resutl = foFunctionService.insertSelective(foFunction);
            if(resutl == 1) {
                return WebResultUtil.success(map, "系统功能新增成功！", "/admin/function/list");
            }
        }
        return "admin/function/add";
    }

    /**
     * 删除功能列表
     * */
    @GetMapping(value = "/function/del")
    public void functionDel(FoFunction foFunction, HttpServletResponse response) throws Exception{
        foFunctionService.deleteByPrimaryKey(foFunction.getId());
        response.sendRedirect("/admin/function/list");
    }


    /**
     * 左侧功能列表 ajax 搜索功能
     * */
    @PostMapping(value = "/function/ajaxleftlist")
    public String functionAjaxLeftList(@RequestParam(value = "search", required = false) String search,
                                       ModelMap map){
        List<FoFunction> foList = null;
        if(search != null && search.length() != 0) {
            List<FoFunction> cctList = foFunctionService.selectByfnameLike(search);//得到子功能ID，ID
            if(cctList != null && cctList.size() > 0){
                List<FoFunction> fftList = foFunctionService.selectByinchildId(cctList);//得到父功能ID，ID
                if(fftList != null && fftList.size() > 0){
                    foList = foFunctionService.selectByfid(0,true,null,fftList);
                    for (FoFunction fo : foList) {
                        fo.setClist(foFunctionService.selectByfid(fo.getId(),true,cctList,null));
                    }
                }
            }
        }
        map.addAttribute("leftList",foList);
        map.addAttribute("search",search);
        return "admin/function/ajaxleftlist";
    }



    //TODO 对应用户权限功能列表当前方法可以，判断用户是否有权限 还是单一判断列表页也可以使用indexOf，参考php
}
