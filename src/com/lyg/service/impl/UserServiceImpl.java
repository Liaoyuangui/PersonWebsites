package com.lyg.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.lyg.dao.UsersMapper;
import com.lyg.entitys.Users;
import com.lyg.service.IUserService;

@Service
public class UserServiceImpl implements IUserService {

	@Autowired
	private UsersMapper userDao;
	@Override
	public Users getUsersByUserName(String userName) {
		return userDao.getUsersByUserName(userName);
	}
	@Override
	public int insert(Users user) {
		return userDao.insertSelective(user);
	}
	@Override
	public int updateByPrimaryKeySelective(Users record) {
		// TODO Auto-generated method stub
		return userDao.updateByPrimaryKeySelective(record);
	}
	@Override
	public int deleteUsersById(Integer id) {
		// TODO Auto-generated method stub
		return userDao.deleteUsersById(id);
	}

}
