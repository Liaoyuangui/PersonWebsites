package com.lyg.dao;

import org.springframework.stereotype.Repository;

import com.lyg.entitys.Users;

@Repository
public interface UsersMapper {
    int deleteByPrimaryKey(Integer id);

    int insert(Users record);

    Users selectByPrimaryKey(Integer id);

    int updateByPrimaryKey(Users record);
    
    //根据用户名查询
    public Users getUsersByUserName(String userName);
    
    //修改
    int updateByPrimaryKeySelective(Users record);
    
    //添加
    int insertSelective(Users record);
    
    //删除
    int deleteUsersById(Integer id);
}