package com.lyg.service;

import org.springframework.stereotype.Service;

import com.lyg.entitys.PersonInfo;

@Service
public interface IUserInfoService {
  
	//保存上传的照片
	public int uploadImage(PersonInfo uploadFile);
	
	 //根据用户id查询 
    public PersonInfo selectByUserId(Integer userId);
    
    //插入
    public int insertSelective(PersonInfo record);
    
    //根据用户id修改
    public int updateByUserId(PersonInfo personInfo);
    
  //根据用户id连表查询
    public Object selectUserAndPersonByUserId(Integer userId);
}
