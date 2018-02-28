package com.lyg.service;

import java.util.List;

import org.springframework.stereotype.Service;

import com.lyg.entitys.Theme;
@Service
public interface IThemeService {
	
    //根据id查询
   public Theme selectByPrimaryKey(Integer id);
    //添加
   public int insertSelective(Theme record);
    //修改
   public int updateByPrimaryKeySelective(Theme record);
    //查询所有的
   public  List<Theme> selectAlltheme(Theme record);
    //删除
   public  int deleteThemeById(Integer id);
    //启用主题
   public int startThemeById(Integer id);
    //禁用主题
   public int stopThemeById(Integer id);
   //查询所有的除开当前的id之外
   List<Theme> selectAllThemeCkById(Integer id);

}
