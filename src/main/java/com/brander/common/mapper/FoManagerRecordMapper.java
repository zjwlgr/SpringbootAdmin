package com.brander.common.mapper;

import com.brander.common.domain.FoManagerRecord;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface FoManagerRecordMapper {
    int deleteByPrimaryKey(Integer id);

    int insert(FoManagerRecord record);

    int insertSelective(FoManagerRecord record);

    FoManagerRecord selectByPrimaryKey(Integer id);

    int updateByPrimaryKeySelective(FoManagerRecord record);

    int updateByPrimaryKey(FoManagerRecord record);

    List<FoManagerRecord> selectJoinFoManager(@Param("search") String search);
}