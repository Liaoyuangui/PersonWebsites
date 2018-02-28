package com.lyg.service;

import com.lyg.entitys.UserRole;

public interface IUserRoleService {

	//根据id 查询权限信息
	public UserRole getRoleById(Integer roleId);
}
