package com.brander.common.service;

import com.brander.common.domain.FoManagerGroup;
import com.brander.common.mapper.FoManagerGroupMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

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

    /**
     * 查询用户组列表 全部 或 search 查询
     * */
    public List<FoManagerGroup> selectByList(String search){
        return foManagerGroupMapper.selectByList(search);
    }

}
