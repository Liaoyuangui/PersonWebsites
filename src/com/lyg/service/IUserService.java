package com.lyg.service;

import org.springframework.stereotype.Service;

import com.lyg.entitys.Users;

@Service
public interface IUserService {
	
	//根据用户名查询
	public Users getUsersByUserName(String userName);
	
	//插入
	public  int insert(Users user);
	
	
	 //修改
    public  int updateByPrimaryKeySelective(Users record);
    
    
    //删除
    public  int deleteUsersById(Integer id);
	

}
