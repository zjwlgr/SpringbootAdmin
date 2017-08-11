package com.brander.admin.controller;

import com.brander.common.domain.FoFunction;
import com.brander.common.service.FoFunctionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

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




}
