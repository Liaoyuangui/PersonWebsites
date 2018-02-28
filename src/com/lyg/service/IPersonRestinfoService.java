package com.lyg.service;

import java.util.List;

import org.springframework.stereotype.Service;

import com.lyg.entitys.PersonRestinfo;
@Service
public interface IPersonRestinfoService {
	//添加
   public int insertSelective(PersonRestinfo record);
    //根据id查询
   public  PersonRestinfo selectByPrimaryKey(Integer id);
    //修改    
   public int updateByPrimaryKeySelective(PersonRestinfo record);
    //查询所有的
   public List<Object> selectAllPersonRestInfo(PersonRestinfo record);

}
