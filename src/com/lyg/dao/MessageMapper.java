package com.lyg.dao;

import java.util.List;

import org.springframework.stereotype.Repository;

import com.lyg.entitys.Message;
@Repository
public interface MessageMapper {
    int deleteByPrimaryKey(Integer id);

    int insert(Message record);

    int insertSelective(Message record);

    int updateByPrimaryKeySelective(Message record);

    int updateByPrimaryKey(Message record);
    
    //根据id查询
    public  Message selectByPrimaryKey(Integer id);
    
    //查询所有的
    public List<Message> selectAllMessage(Message message);
    
    //匿名留言
    public int insertNmMessage(Message message);    
    
    //实名留言
    public int insertSmMessage(Message message);    
    
    //留言删除
    public int deleteMessageById(Integer id);
    
    //留言回复
    
}