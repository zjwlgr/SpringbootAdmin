package com.brander.common.mapper;

import com.brander.common.domain.FoFunction;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface FoFunctionMapper {
    int deleteByPrimaryKey(Integer id);

    int insert(FoFunction record);

    int insertSelective(FoFunction record);

    FoFunction selectByPrimaryKey(Integer id);

    int updateByPrimaryKeySelective(FoFunction record);

    int updateByPrimaryKey(FoFunction record);

    //根据fid返回对应功能列表,idin取item.id,,,,fidin取item.fid
    List<FoFunction> selectByfid(Integer fid,boolean state,List<FoFunction> idin,List<FoFunction> fidin);

    //根据关键字like查询 @ 搜索子功能（fid<>0 为子功能） 根据关键字
    List<FoFunction> selectByfnameLike(String search);

    //通过子功能ID，查询父功能ID，ID
    List<FoFunction> selectByinchildId(@Param("cctList") List<FoFunction> cctList);
}