package com.lyg.dao;

import org.springframework.stereotype.Repository;

import com.lyg.entitys.PersonInfo;

@Repository
public interface PersonInfoMapper {
    int deleteByPrimaryKey(Integer id);

    int insert(PersonInfo record);

    //根据条件插入
    int insertSelective(PersonInfo record);

    PersonInfo selectByPrimaryKey(Integer id);

    int updateByPrimaryKeySelective(PersonInfo record);

    int updateByPrimaryKey(PersonInfo record);
    
    //根据用户id查询 
    public PersonInfo selectByUserId(Integer userId);
    
    //根据用户id修改
    public int updateByUserId(PersonInfo personInfo);
    
    //根据用户id连表查询
    public Object selectUserAndPersonByUserId(Integer userId);
}