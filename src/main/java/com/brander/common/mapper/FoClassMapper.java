package com.brander.common.mapper;

import com.brander.common.domain.FoClass;

import java.util.List;

public interface FoClassMapper {
    int deleteByPrimaryKey(Integer id);

    int insert(FoClass record);

    int insertSelective(FoClass record);

    FoClass selectByPrimaryKey(Integer id);

    int updateByPrimaryKeySelective(FoClass record);

    int updateByPrimaryKey(FoClass record);

    //通过 FID 查询一个父下面子分类的集合
    List<FoClass> selectByfid(Integer fid);

    //通过 FID 查询子分类总数
    int selectFidCount(Integer fid);
}