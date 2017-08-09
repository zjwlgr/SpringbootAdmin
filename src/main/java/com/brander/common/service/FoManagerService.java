package com.brander.common.service;

import com.brander.common.domain.FoManager;
import com.brander.common.enums.JsonResultEnum;
import com.brander.common.exception.JsonException;
import com.brander.common.mapper.FoManagerMapper;
import com.brander.common.utils.AchieveUtil;
import com.brander.common.utils.MD5Util;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.servlet.http.HttpServletRequest;

@Service
public class FoManagerService {

    @Autowired
    FoManagerMapper foManagerMapper;

    /**
    * 管理员登录，判断用户存在、验证密码、用户是否被锁定
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
    * */
    public int updateByPrimaryKeySelective(FoManager foManager, HttpServletRequest request){
        foManager.setLoginIp(AchieveUtil.getIpAddr(request));
        foManager.setNumber(foManager.getNumber() + 1);
        foManager.setLoginTime(AchieveUtil.getTimeStamp());
        return foManagerMapper.updateByPrimaryKeySelective(foManager);
    }


}
