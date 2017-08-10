package com.brander.common.mapper;

import com.brander.common.domain.FoManagerGroup;

public interface FoManagerGroupMapper {
    int deleteByPrimaryKey(Integer id);

    int insert(FoManagerGroup record);

    int insertSelective(FoManagerGroup record);

    FoManagerGroup selectByPrimaryKey(Integer id);

    int updateByPrimaryKeySelective(FoManagerGroup record);

    int updateByPrimaryKey(FoManagerGroup record);
}