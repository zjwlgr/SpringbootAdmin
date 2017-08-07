package com.brander.common.mapper;

import com.brander.common.domain.fo_manager;

public interface fo_managerMapper {
    int deleteByPrimaryKey(Integer id);

    int insert(fo_manager record);

    int insertSelective(fo_manager record);

    fo_manager selectByPrimaryKey(Integer id);

    int updateByPrimaryKeySelective(fo_manager record);

    int updateByPrimaryKey(fo_manager record);
}