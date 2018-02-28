package com.lyg.service;

import java.util.List;

import org.springframework.stereotype.Service;

import com.lyg.entitys.Myalbum;
@Service
public interface IMyAlbumService {
	
	
	//根据条件插入
	   public int addAlbum(Myalbum record);
	//根据id查询
	   public Myalbum selectByPrimaryKey(Integer id);
	//根据条件动态修改
	   public int updateByPrimaryKeySelective(Myalbum record);

	//查询所有的
	   public List<Myalbum> queryAllMyalbum(Myalbum myalbum);
	//删除
	   public int  deleteAlbumById(Integer albumId);

}
