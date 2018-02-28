package com.lyg.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.lyg.dao.PersonRestinfoMapper;
import com.lyg.entitys.PersonRestinfo;
import com.lyg.service.IPersonRestinfoService;
@Service
public class PersonRestinfoServiceImpl implements IPersonRestinfoService {

	@Autowired
	private PersonRestinfoMapper restInfoDao;
	@Override
	public int insertSelective(PersonRestinfo record) {
		// TODO Auto-generated method stub
		return restInfoDao.insertSelective(record);
	}

	@Override
	public PersonRestinfo selectByPrimaryKey(Integer id) {
		// TODO Auto-generated method stub
		return restInfoDao.selectByPrimaryKey(id);
	}

	@Override
	public int updateByPrimaryKeySelective(PersonRestinfo record) {
		// TODO Auto-generated method stub
		return restInfoDao.updateByPrimaryKeySelective(record);
	}

	@Override
	public List<Object> selectAllPersonRestInfo(PersonRestinfo record) {
		// TODO Auto-generated method stub
		return restInfoDao.selectAllPersonRestInfo(record);
	}

}
