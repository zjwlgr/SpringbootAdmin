package com.brander.common.mapper;

import com.brander.common.domain.FoManager;

import java.util.List;

public interface FoManagerMapper {
    int deleteByPrimaryKey(Integer id);

    int insert(FoManager record);

    int insertSelective(FoManager record);

    FoManager selectByPrimaryKey(Integer id);

    int updateByPrimaryKeySelective(FoManager record);

    int updateByPrimaryKey(FoManager record);

    //根据用户名查询单条数据
    FoManager selectByUsername(String username);

    //管理员列表
    List<FoManager> selectByList(Integer groupId,String search);
}