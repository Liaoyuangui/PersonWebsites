package com.lyg.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.lyg.dao.PersonInfoMapper;
import com.lyg.entitys.PersonInfo;
import com.lyg.service.IUserInfoService;

@Service
public class UserInfoServiceImpl implements IUserInfoService {

	@Autowired
	private PersonInfoMapper personDao;
	@Override
	public int uploadImage(PersonInfo uploadFile) {
		return personDao.insertSelective(uploadFile);
	}
	@Override
	public PersonInfo selectByUserId(Integer userId) {
		// TODO Auto-generated method stub
		return personDao.selectByUserId(userId);
	}
	@Override
	public int insertSelective(PersonInfo record) {
		// TODO Auto-generated method stub
		return personDao.insertSelective(record);
	}
	@Override
	public int updateByUserId(PersonInfo personInfo) {
		// TODO Auto-generated method stub
		return personDao.updateByUserId(personInfo);
	}
	@Override
	public Object selectUserAndPersonByUserId(Integer userId) {
		// TODO Auto-generated method stub
		return personDao.selectUserAndPersonByUserId(userId);
	}

}
