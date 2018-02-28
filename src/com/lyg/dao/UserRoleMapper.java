package com.lyg.dao;

import com.lyg.entitys.UserRole;

public interface UserRoleMapper {
    int deleteByPrimaryKey(Integer roleId);

    int insert(UserRole record);

    int insertSelective(UserRole record);

    UserRole selectByPrimaryKey(Integer roleId);

    int updateByPrimaryKeySelective(UserRole record);

    int updateByPrimaryKey(UserRole record);
}