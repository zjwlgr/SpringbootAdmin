package com.brander.admin.controller;

import com.brander.common.domain.AdminTitle;
import com.brander.common.domain.FoManager;
import com.brander.common.domain.FoManagerGroup;
import com.brander.common.service.FoManagerGroupService;
import com.brander.common.service.FoManagerService;
import com.brander.common.utils.PageUtil;
import com.brander.common.utils.WebResultUtil;
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

        //管理员列表，分页
        List<FoManager> foManager = foManagerService.selectByList(fmr);
        PageInfo pageInfo = new PageInfo<FoManager>(foManager);
        map.addAttribute("pageInfo",pageInfo);
        map.addAttribute("pageshow", PageUtil.show(pageInfo,request));

        //用户组列表
        map.addAttribute("groupList",foManagerGroupService.selectByOption());

        //选择分组查看 select 中 当前被选择的用户组名称
        FoManagerGroup foManagerGroup = foManagerGroupService.selectByPrimaryKey(fmr.getGroupId());
        String foGroupNmae = null;
        if(foManagerGroup != null) {
            foGroupNmae = foManagerGroup.getGname();
        }
        map.addAttribute("selectGroupname", foGroupNmae);

        return "admin/manager/list";
    }

    /**
     * 新增管理员
     * */
    @RequestMapping(value = "/manager/add")
    public String managerAdd(ModelMap map,FoManager foManager,HttpServletRequest request){
        if(request.getMethod().equals("GET")) {
            AdminTitle adminTitle = new AdminTitle();
            adminTitle.setTitle1("管理员管理");
            adminTitle.setTitle2("新增");
            map.addAttribute("adminTitle", adminTitle);
            //管理员总数
            map.addAttribute("userCount", foManagerService.selectByCount());
            //用户组列表
            map.addAttribute("groupList", foManagerGroupService.selectByOption());
            return "admin/manager/add";
        }else if(request.getMethod().equals("POST")){
            boolean result = foManagerService.insertSelective(foManager,request);
            if(result){
                return WebResultUtil.success(map,"管理员新增成功！","/admin/manager/list");
            }else{
                return WebResultUtil.error(map,"用户"+foManager.getUsername()+"已存在，请更换！！","/admin/manager/add");
            }
        }
        return "";
    }

    /**
     * 编辑管理员
     * */
    @RequestMapping(value = "/manager/up")
    public String managerUpdate(ModelMap map,FoManager foManager,HttpServletRequest request){
        if(request.getMethod().equals("GET")) {
            AdminTitle adminTitle = new AdminTitle();
            adminTitle.setTitle1("管理员管理");
            adminTitle.setTitle2("编辑");
            map.addAttribute("adminTitle", adminTitle);
            //返回当前用户对象
            FoManager managerUser = foManagerService.selectByPrimaryKey(foManager.getId());
            map.addAttribute("managerUser",managerUser);
            //管理员总数
            map.addAttribute("userCount", foManagerService.selectByCount());
            //用户组列表
            map.addAttribute("groupList", foManagerGroupService.selectByOption());
            //对应用户的用户组名称
            map.addAttribute("groupName",foManagerGroupService.selectByPrimaryKey(managerUser.getGroupId()).getGname());
            return "admin/manager/up";
        }else if(request.getMethod().equals("POST")){
            boolean result = foManagerService.updateByPrimaryKeySelectivePassword(foManager);
            if(result){
                return WebResultUtil.success(map,"管理员编辑成功！","/admin/manager/list");
            }else{
                return WebResultUtil.error(map,"用户"+foManager.getUsername()+"已存在，请更换！！","/admin/manager/up?id="+foManager.getId());
            }
        }
        return "";
    }

    /**
     * 密理员修改密码
     * */
    @RequestMapping(value = "/editpwd")
    public String editPassword(ModelMap map,FoManager foManager,HttpServletRequest request){
        if(request.getMethod().equals("GET")) {
            AdminTitle adminTitle = new AdminTitle();
            adminTitle.setTitle1("修改密码");
            map.addAttribute("adminTitle", adminTitle);
            return "admin/manager/editpwd";
        }else if(request.getMethod().equals("POST")){
            int adminId = (int)(request.getSession().getAttribute("adminId"));
            boolean result = foManagerService.updatePassword(foManager,adminId);
            if(result){
                return WebResultUtil.success(map,"密码修改成功，页面跳转后将重新登录！","/admin/loginout");
            }else{
                return WebResultUtil.error(map,"旧密码输入错误！","/admin/editpwd");
            }
        }
        return "";
    }

    /**
    * 删除管理员操作
    * */
    @GetMapping(value = "/manager/del")
    public void managerDel(FoManager foManager, HttpServletResponse response) throws Exception{
        foManagerService.deleteByPrimaryKey(foManager.getId());
        response.sendRedirect("/admin/manager/list");
    }

}
