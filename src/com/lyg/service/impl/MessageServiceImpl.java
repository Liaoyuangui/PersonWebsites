package com.lyg.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.lyg.dao.MessageMapper;
import com.lyg.entitys.Message;
import com.lyg.service.IMessageService;
@Service
public class MessageServiceImpl implements IMessageService {

	@Autowired
	private MessageMapper messageDao;
	@Override
	public Message selectByPrimaryKey(Integer id) {
		// TODO Auto-generated method stub
		return messageDao.selectByPrimaryKey(id);
	}

	@Override
	public List<Message> selectAllMessage(Message message) {
		// TODO Auto-generated method stub
		return messageDao.selectAllMessage(message);
	}

	@Override
	public int insertNmMessage(Message message) {
		// TODO Auto-generated method stub
		return messageDao.insertSelective(message);
	}

	@Override
	public int insertSmMessage(Message message) {
		// TODO Auto-generated method stub
		return messageDao.insertSelective(message);
	}

	@Override
	public int deleteMessageById(Integer id) {
		// TODO Auto-generated method stub
		return messageDao.deleteMessageById(id);
	}

}
