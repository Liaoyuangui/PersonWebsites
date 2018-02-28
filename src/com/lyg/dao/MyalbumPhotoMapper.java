package com.lyg.dao;

import java.util.List;

import org.springframework.stereotype.Repository;

import com.lyg.entitys.MyalbumPhoto;
@Repository
public interface MyalbumPhotoMapper {
    int deleteByPrimaryKey(Integer photoId);

    int insert(MyalbumPhoto record);

    int insertSelective(MyalbumPhoto record);

    MyalbumPhoto selectByPrimaryKey(Integer photoId);

    int updateByPrimaryKeySelective(MyalbumPhoto record);

    int updateByPrimaryKey(MyalbumPhoto record);
    
    //批量插入
    int  insersBatch(List<MyalbumPhoto> list);
    
    //删除
    int  deletePhotoById(Integer photoId);
    
    //查询相册下的所有照片
    List<MyalbumPhoto> selectAllPhotoByAlbumId(Integer albumId);
    
    //查询所有的除第一张展示的除外
    List<MyalbumPhoto> selectAllPhotoCKphotoId(MyalbumPhoto record);
    
    //统计该相册下的总数
    int selectSumPhotoByAlbumId(Integer albumId);
    
}