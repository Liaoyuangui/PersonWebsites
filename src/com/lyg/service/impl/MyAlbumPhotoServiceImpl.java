package com.lyg.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.lyg.dao.MyalbumPhotoMapper;
import com.lyg.entitys.MyalbumPhoto;
import com.lyg.service.IMyAlbumPhotoService;

@Service
public class MyAlbumPhotoServiceImpl implements IMyAlbumPhotoService {

	@Autowired
	private MyalbumPhotoMapper photoDao;
	@Override
	public int insersBatch(List<MyalbumPhoto> list) {
		// TODO Auto-generated method stub
		return photoDao.insersBatch(list);
	}

	@Override
	public int deletePhotoById(Integer photoId) {
		// TODO Auto-generated method stub
		return photoDao.deletePhotoById(photoId);
	}

	@Override
	public List<MyalbumPhoto> selectAllPhotoByAlbumId(Integer albumId) {
		// TODO Auto-generated method stub
		return photoDao.selectAllPhotoByAlbumId(albumId);
	}

	@Override
	public List<MyalbumPhoto> selectAllPhotoCKphotoId(MyalbumPhoto record) {
		// TODO Auto-generated method stub
		return photoDao.selectAllPhotoCKphotoId(record);
	}

	@Override
	public MyalbumPhoto selectPhotoById(Integer photoId) {
		// TODO Auto-generated method stub
		return photoDao.selectByPrimaryKey(photoId);
	}

	@Override
	public int selectSumPhotoByAlbumId(Integer albumId) {
		// TODO Auto-generated method stub
		return photoDao.selectSumPhotoByAlbumId(albumId);
	}

}
