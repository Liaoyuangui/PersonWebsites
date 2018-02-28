package com.lyg.service;

import java.util.List;

import org.springframework.stereotype.Service;

import com.lyg.entitys.Message;
@Service
public interface IMessageService {

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
}
