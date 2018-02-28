package com.lyg.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.lyg.dao.MediaMapper;
import com.lyg.entitys.Media;
import com.lyg.service.IMediaService;
@Service
public class MediaServiceImpl implements IMediaService {
	@Autowired
	private MediaMapper mediaDao;

	@Override
	public Media selectByPrimaryKey(Integer id) {
		// TODO Auto-generated method stub
		return mediaDao.selectByPrimaryKey(id);
	}

	@Override
	public int insertSelective(Media record) {
		// TODO Auto-generated method stub
		return mediaDao.insertSelective(record);
	}

	@Override
	public int updateByPrimaryKeySelective(Media record) {
		// TODO Auto-generated method stub
		return mediaDao.updateByPrimaryKeySelective(record);
	}

	@Override
	public List<Media> selectAllMedia(Media media) {
		// TODO Auto-generated method stub
		return mediaDao.selectAllMedia(media);
	}

	@Override
	public int deleteMediaById(Integer id) {
		// TODO Auto-generated method stub
		return mediaDao.deleteMediaById(id);
	}

}
