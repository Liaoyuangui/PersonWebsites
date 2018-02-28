package com.lyg.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.lyg.dao.UserRoleMapper;
import com.lyg.entitys.UserRole;
import com.lyg.service.IUserRoleService;

@Service
public class UserRoleServiceImpl implements IUserRoleService {

	@Autowired
	private UserRoleMapper roleDao;
	
	@Override
	public UserRole getRoleById(Integer roleId) {
		return roleDao.selectByPrimaryKey(roleId);
	}

}
