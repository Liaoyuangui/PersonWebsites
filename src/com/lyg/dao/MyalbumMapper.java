package com.lyg.dao;

import java.util.List;

import org.springframework.stereotype.Repository;

import com.lyg.entitys.Myalbum;
@Repository
public interface MyalbumMapper {
    int deleteByPrimaryKey(Integer albumId);

    int insert(Myalbum record);

    //添加
    int insertSelective(Myalbum record);

    //根据id查询
    Myalbum selectByPrimaryKey(Integer albumId);

    //修改
    int updateByPrimaryKeySelective(Myalbum record);

    int updateByPrimaryKey(Myalbum record);
    
    //查詢所有的
    List<Myalbum> queryAllMyalbum(Myalbum record);
    
    //删除
    int  deleteAlbumById(Integer albumId);
}