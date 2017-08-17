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
     * 添加分类
     * */
    public int insertSelective(FoClass foClass){
        String oneNexus;
        if(foClass.getFid() != 0){
            FoClass fcOne = this.selectByPrimaryKey(foClass.getFid());
            oneNexus = fcOne.getNexus();
        }else{
            oneNexus = "";
        }
        foClass.setNexus(oneNexus + foClass.getNexus());
        return foClassMapper.insertSelective(foClass);
    }

    /**
     * Ajax 编辑分类
     * */
    public int updateByPrimaryKeySelective(FoClass foClass){
        return foClassMapper.updateByPrimaryKeySelective(foClass);
    }

    /**
     * 通过 FID 查询子分类总数
     * */
    public int selectFidCount(Integer fid){
        return foClassMapper.selectFidCount(fid);
    }


    /**
     * 根据ID查询一个对象
     * */
    public FoClass selectByPrimaryKey(Integer id){
        return foClassMapper.selectByPrimaryKey(id);
    }

    /**
     * 根据ID删除一条分类
     * */
    public int deleteByPrimaryKey(Integer id){
        return foClassMapper.deleteByPrimaryKey(id);
    }

    /**
     * 根据FID删除所有关联分类
    * */
    public int deleteByNexus(Integer fid){
        return foClassMapper.deleteByNexus(fid);
    }

}
