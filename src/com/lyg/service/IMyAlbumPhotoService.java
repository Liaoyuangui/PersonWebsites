package com.lyg.service;

import java.util.List;

import org.springframework.stereotype.Service;

import com.lyg.entitys.MyalbumPhoto;
@Service
public interface IMyAlbumPhotoService {

	//批量插入
   public  int  insersBatch(List<MyalbumPhoto> list);
    
    //删除
   public  int  deletePhotoById(Integer photoId);
    
    //查询相册下的所有照片
   public List<MyalbumPhoto> selectAllPhotoByAlbumId(Integer albumId);
   
   //查询所有的除第一张展示的除外
   List<MyalbumPhoto> selectAllPhotoCKphotoId(MyalbumPhoto record);
   
   //根据id查询
   public  MyalbumPhoto selectPhotoById(Integer photoId);
   
   public int selectSumPhotoByAlbumId(Integer albumId);
}
