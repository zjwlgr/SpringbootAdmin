package com.brander.common.service;

import com.brander.common.domain.FoManagerGroup;
import com.brander.common.mapper.FoManagerGroupMapper;
import com.github.pagehelper.PageHelper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class FoManagerGroupService {

    @Autowired
    FoManagerGroupMapper foManagerGroupMapper;

    /**
     * 根据主键ID查询
     * */
    public FoManagerGroup selectByPrimaryKey(Integer id){
        return foManagerGroupMapper.selectByPrimaryKey(id);
    }

    /**
     * 用户组列表，下拉菜单用
     * */
    public List<FoManagerGroup> selectByOption(){
        return foManagerGroupMapper.selectByOption();
    }

    /**
     * 查询用户组列表 全部 或 search 查询
     * */
    public List<FoManagerGroup> selectByList(FoManagerGroup foManagerGroup){
        if (foManagerGroup.getPage() != null && foManagerGroup.getRows() != null) {
            PageHelper.startPage(foManagerGroup.getPage(), foManagerGroup.getRows());
        }
        return foManagerGroupMapper.selectByList(foManagerGroup.getSearch());
    }

    /**
     * 新增管理员分组
     * */
    public int insertSelective(FoManagerGroup foManagerGroup){
        return foManagerGroupMapper.insertSelective(foManagerGroup);
    }

    /**
     * 编辑管理员分组
     * */
    public int updateByPrimaryKeySelective(FoManagerGroup foManagerGroup){
        return foManagerGroupMapper.updateByPrimaryKeySelective(foManagerGroup);
    }

    /**
     * 删除管理员分组
     * */
    public int deleteByPrimaryKey(FoManagerGroup foManagerGroup){
        return foManagerGroupMapper.deleteByPrimaryKey(foManagerGroup.getId());
    }

    /**
     * 查询管理员分组总数
     * */
    public int selectByCount(){
        return foManagerGroupMapper.selectByCount();
    }

}
