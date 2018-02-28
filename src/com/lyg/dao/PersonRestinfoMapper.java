package com.lyg.dao;

import java.util.List;

import org.springframework.stereotype.Repository;

import com.lyg.entitys.PersonRestinfo;
@Repository
public interface PersonRestinfoMapper {
    int deleteByPrimaryKey(Integer id);

    int insert(PersonRestinfo record);

    int updateByPrimaryKey(PersonRestinfo record);
    //添加
    int insertSelective(PersonRestinfo record);
    //根据id查询
    PersonRestinfo selectByPrimaryKey(Integer id);
    //修改    
    int updateByPrimaryKeySelective(PersonRestinfo record);
    //查询所有的
    List<Object> selectAllPersonRestInfo(PersonRestinfo record);
}