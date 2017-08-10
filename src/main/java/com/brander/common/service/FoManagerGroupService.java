package com.brander.common.service;

import com.brander.common.domain.FoManagerGroup;
import com.brander.common.mapper.FoManagerGroupMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class FoManagerGroupService {

    @Autowired
    FoManagerGroupMapper foManagerGroupMapper;

    /**
     * 根据主键ID查询
     * */
    public FoManagerGroup selectByPrimaryKey(Integer id){
        return foManagerGroupMapper.selectByPrimaryKey(id);
    }

}
