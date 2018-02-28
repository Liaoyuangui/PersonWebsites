package com.lyg.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.lyg.dao.UsersMapper;
import com.lyg.entitys.Users;
import com.lyg.service.ILoginService;

@Service
public class LoginserviceImpl implements ILoginService {
    
	@Autowired
	private UsersMapper  dao;
	@Override
	public int insert(Users user) {
		return	dao.insert(user);
	}

}
