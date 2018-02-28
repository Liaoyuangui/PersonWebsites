package com.lyg.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.lyg.dao.MyalbumMapper;
import com.lyg.entitys.Myalbum;
import com.lyg.service.IMyAlbumService;
@Service
public class MyAlbumServiceImpl implements IMyAlbumService {
    @Autowired
	private MyalbumMapper albumDao;
	
	@Override
	public int addAlbum(Myalbum record) {
		// TODO Auto-generated method stub
		return albumDao.insertSelective(record);
	}

	@Override
	public Myalbum selectByPrimaryKey(Integer id) {
		// TODO Auto-generated method stub
		return albumDao.selectByPrimaryKey(id);
	}

	@Override
	public int updateByPrimaryKeySelective(Myalbum record) {
		// TODO Auto-generated method stub
		return albumDao.updateByPrimaryKeySelective(record);
	}

	@Override
	public List<Myalbum> queryAllMyalbum(Myalbum myalbum) {
		// TODO Auto-generated method stub
		return albumDao.queryAllMyalbum(myalbum);
	}

	@Override
	public int deleteAlbumById(Integer albumId) {
		// TODO Auto-generated method stub
		return albumDao.deleteAlbumById(albumId);
	}

}
