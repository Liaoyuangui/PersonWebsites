package com.lyg.dao;

import java.util.List;

import org.springframework.stereotype.Repository;

import com.lyg.entitys.Media;
@Repository
public interface MediaMapper {
    int deleteByPrimaryKey(Integer id);

    int insert(Media record);


    int updateByPrimaryKey(Media record);
    
    //根据id查询
    Media selectByPrimaryKey(Integer id);
    
    //添加
    int insertSelective(Media record);
    
    //修改
    int updateByPrimaryKeySelective(Media record);
    
    //查询所有的
    List<Media> selectAllMedia(Media media);
    
    //删除
    int deleteMediaById(Integer id);
}