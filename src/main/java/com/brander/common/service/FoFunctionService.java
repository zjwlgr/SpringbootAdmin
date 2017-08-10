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
    public List<FoFunction> selectByfid(Integer fid){
        return foFunctionMapper.selectByfid(fid);
    }

}
