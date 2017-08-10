package com.brander.common.mapper;

import com.brander.common.domain.FoFunction;

import java.util.List;

public interface FoFunctionMapper {
    int deleteByPrimaryKey(Integer id);

    int insert(FoFunction record);

    int insertSelective(FoFunction record);

    FoFunction selectByPrimaryKey(Integer id);

    int updateByPrimaryKeySelective(FoFunction record);

    int updateByPrimaryKey(FoFunction record);

    //根据fid返回对应功能列表
    List<FoFunction> selectByfid(Integer fid);
}