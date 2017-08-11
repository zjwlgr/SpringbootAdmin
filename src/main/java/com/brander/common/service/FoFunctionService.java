package com.brander.common.service;

import com.brander.common.domain.FoFunction;
import com.brander.common.mapper.FoFunctionMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class FoFunctionService {

    @Autowired
    FoFunctionMapper foFunctionMapper;

    /**
     * 根据fid返回对应功能列表
     * */
    public List<FoFunction> selectByfid(Integer fid,boolean state,List<FoFunction> idin,List<FoFunction> fidin){
        return foFunctionMapper.selectByfid(fid,state,idin,fidin);
    }

    /**
     * 根据关键字like查询 @ 搜索子功能（fid<>0 为子功能） 根据关键字
     * */
    public List<FoFunction> selectByfnameLike(String search){
        return foFunctionMapper.selectByfnameLike(search);
    }

    /**
     * 通过子功能ID，查询父功能ID，ID
     * */
    public List<FoFunction> selectByinchildId(List<FoFunction> cctList){
        return foFunctionMapper.selectByinchildId(cctList);
    };
}
