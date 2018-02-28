package com.lyg.web.controller;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.lyg.entitys.Message;
import com.lyg.entitys.Users;
import com.lyg.service.IMessageService;

@Controller
@RequestMapping("message")
public class MessageController {
	@Autowired
	private IMessageService messageService;
	 
	/**
	 * 根据id查询
	 * @param id
	 * @return
	 */
	@ResponseBody
	@RequestMapping("selectById.do")
    public  Message selectById(Integer messageId) {
		if(messageId !=null ) {
		 return	messageService.selectByPrimaryKey(messageId);
		}else {
			return null;
		}
    }
    
    /**
     * 查询所有的
     * @param message
     * @return
     */
	@ResponseBody
	@RequestMapping("selectAllMessage.do")
    public List<Message> selectAllMessage(Message message,Integer isNm){
		List<Message> list = new ArrayList<>();
		if(isNm != null) {
			message.setIsNm(isNm); //是否匿名 1是  0否
		}
		list=messageService.selectAllMessage(message);
		
    	return list;
    }
    /**
     * 匿名留言
     * @param userName 用户名
     * @param txUrl    头像地址
     * @param content  内容
     * @return
     */
	@ResponseBody
	@RequestMapping("insertNmMessage.do")
    public int insertNmMessage(HttpSession session,String content){
		Users user = (Users)session.getAttribute("userInfo");
		String userName = user.getLoginName();
		String txUrl = user.getUserTx();
		Message message = new Message();
		if(userName!=null) {
			message.setUserNickname(userName);
		}
		if(txUrl!=null) {
			message.setUserTx(txUrl);
		}
		if(content!=null) {
			message.setContent(content);
		}
		//设置时间戳
		Date date = new Date();
		SimpleDateFormat sim = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
		message.setAddTime(sim.format(date));
		message.setIsNm(1); //0实名  1 匿名
		int result = messageService.insertNmMessage(message);
    	return result;
    }
    /**
     * 实名留言
     * @param message
     * @return
     */
	@ResponseBody
	@RequestMapping("insertSmMessage.do")
    public int insertSmMessage(String name,String email,String phone,String content) {
		Message message = new Message();
		message.setName(name);
		message.setEmail(email);
		message.setPhone(phone);
		message.setContent(content);
		
		//设置时间戳
		Date date = new Date();
		SimpleDateFormat sim = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
		message.setAddTime(sim.format(date));
		message.setIsNm(0); //0实名  1 匿名
		int result = messageService.insertSmMessage(message);
    	return result;
    }  
    
    /**
     * 删除留言
     * @param id
     * @return
     */
	@ResponseBody
	@RequestMapping("deleteMessageById.do")
    public int deleteMessageById(Integer messageId) {
		if(messageId != null) {
			return messageService.deleteMessageById(messageId);
		}else {
			return 0;
		}
    }
    
    //留言回复
	
	/**
	 * 检测用户是否登录
	 * @return
	 * session
	 */
	@ResponseBody
	@RequestMapping("checkLogin.do")
	public Map<String, Object> c(HttpSession session){
		//session.setAttribute("userInfo", "hello word");
		Map<String, Object> map = new HashMap<>();
		Object user = session.getAttribute("userInfo");
		if(user == null) {
			map.put("result", "0");
		}else {
			map.put("result", user);
		}
		return map;
	}

}
