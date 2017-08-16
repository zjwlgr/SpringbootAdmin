package com.brander.common.service;

import com.brander.common.domain.FoClass;
import com.brander.common.mapper.FoClassMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * 系统分类 service
 */
@Service
public class FoClassService {

    @Autowired
    FoClassMapper foClassMapper;

    /**
     * 通过 FID 查询一个父下面子分类的集合
     * */
    public List<FoClass> selectByfid(Integer fid,boolean iscount){
        List<FoClass> foClass = foClassMapper.selectByfid(fid);
        if(iscount){
            for(FoClass fc : foClass){
                fc.setZcount(this.selectFidCount(fc.getId()));
            }
        }
        return foClass;
    }

    /**
     * 通过 FID 查询子分类总数
     * */
    public int selectFidCount(Integer fid){
        return foClassMapper.selectFidCount(fid);
    }




}
