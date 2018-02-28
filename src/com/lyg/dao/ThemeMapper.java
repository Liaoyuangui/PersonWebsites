package com.lyg.dao;

import java.util.List;

import org.springframework.stereotype.Repository;

import com.lyg.entitys.Theme;
@Repository
public interface ThemeMapper {
    int deleteByPrimaryKey(Integer id);

    int insert(Theme record);

    int updateByPrimaryKey(Theme record);
    
    //根据id查询
    Theme selectByPrimaryKey(Integer id);
    //添加
    int insertSelective(Theme record);
    //修改
    int updateByPrimaryKeySelective(Theme record);
    //查询所有的
    List<Theme> selectAlltheme(Theme record);
    //删除
    int deleteThemeById(Integer id);
    //启用主题
    int startThemeById(Integer id);
    //禁用主题
    int stopThemeById(Integer id);
    //查询所有的除开当前的id之外
    List<Theme> selectAllThemeCkById(Integer id);
    
    
}