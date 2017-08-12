package com.brander.common.service;

import com.brander.common.domain.FoManager;
import com.brander.common.domain.FoManagerGroup;
import com.brander.common.enums.JsonResultEnum;
import com.brander.common.exception.JsonException;
import com.brander.common.mapper.FoManagerMapper;
import com.brander.common.utils.AchieveUtil;
import com.brander.common.utils.MD5Util;
import com.github.pagehelper.PageHelper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.servlet.http.HttpServletRequest;
import java.util.List;

@Service
public class FoManagerService {

    @Autowired
    FoManagerMapper foManagerMapper;

    @Autowired
    FoManagerGroupService foManagerGroupService;

    /**
    * 管理员登录，判断用户存在、验证密码、用户是否被锁定
    * @param username 用户名
    * @param password 密码
    * */
    public FoManager loginAction(String username,String password) throws Exception{
        FoManager foManager = foManagerMapper.selectByUsername(username);
        if(foManager == null){
            throw new JsonException(JsonResultEnum.ADMIN_USER_NULL);
        }else if(!MD5Util.string2MD5(password).equals(foManager.getPassword())) {
            throw new JsonException(JsonResultEnum.ADMIN_PASS_ERROR);
        }else if(foManager.getLocking() == 1){
            throw new JsonException(JsonResultEnum.ADMIN_USER_LOCKING);
        }
        return foManager;
    }

    /**
    * 编辑管理员用户信息
    * @param foManager Controller中得到的用户对象
    * @param request 当前http请求
    * */
    public int updateByPrimaryKeySelective(FoManager foManager, HttpServletRequest request){
        foManager.setLoginIp(AchieveUtil.getIpAddr(request));
        foManager.setNumber(foManager.getNumber() + 1);
        foManager.setLoginTime(AchieveUtil.getDateTime(""));
        return foManagerMapper.updateByPrimaryKeySelective(foManager);
    }

    /**
     * 管理员列表
     * @param foManager 得到对应地址栏的参数的对象
     * */
    public List<FoManager> selectByList(FoManager foManager){
        if (foManager.getPage() != null && foManager.getRows() != null) {
            PageHelper.startPage(foManager.getPage(), foManager.getRows());
        }
        List<FoManager> fmr = foManagerMapper.selectByList(foManager.getGroupId(),foManager.getSearch());
        for(FoManager fo : fmr){
            FoManagerGroup foManagerGroup = foManagerGroupService.selectByPrimaryKey(fo.getGroupId());
            fo.setGroupName(foManagerGroup.getGname());
        }
        return fmr;
    }


}
