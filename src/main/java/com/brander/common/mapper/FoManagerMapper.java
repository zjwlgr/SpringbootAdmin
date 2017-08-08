package com.brander.common.mapper;

import com.brander.common.domain.FoManager;

public interface FoManagerMapper {
    int deleteByPrimaryKey(Integer id);

    int insert(FoManager record);

    int insertSelective(FoManager record);

    FoManager selectByPrimaryKey(Integer id);

    int updateByPrimaryKeySelective(FoManager record);

    int updateByPrimaryKey(FoManager record);

    //根据用户名查询单条数据
    FoManager selectByUsername(String username);
}