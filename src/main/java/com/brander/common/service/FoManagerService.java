package com.brander.common.service;

import com.brander.common.domain.FoManager;
import com.brander.common.enums.JsonResultEnum;
import com.brander.common.exception.JsonException;
import com.brander.common.mapper.FoManagerMapper;
import com.brander.common.utils.MD5Util;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class FoManagerService {

    @Autowired
    FoManagerMapper foManagerMapper;

    /**
    * 管理员登录，判断用户存在与验证密码
    * */
    public FoManager loginAction(String username,String password) throws Exception{
        FoManager foManager = foManagerMapper.selectByUsername(username);
        if(foManager == null){
            throw new JsonException(JsonResultEnum.ADMIN_USER_NULL);
        }else if(!MD5Util.string2MD5(password).equals(foManager.getPassword())) {
            throw new JsonException(JsonResultEnum.ADMIN_PASS_ERROR);
        }
        return foManager;
    }


}
