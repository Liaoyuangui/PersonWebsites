package com.lyg.register.controller;

import java.io.IOException;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.lyg.entitys.Users;
import com.lyg.service.IUserService;
import com.lyg.unit.MD5;

@Controller
@RequestMapping("RegisterController")
public class RegisterController {

	@Autowired
	private IUserService userService;
	
	/**
	 * 插入（注册）
	 * @param response
	 * @param user
	 * @param map
	 * @throws IOException
	 */
	@RequestMapping(value="userRegister.do")
	public String userRegister(HttpServletResponse response,HttpServletRequest request,Users user,Map<String, Object> map) throws IOException{
		String userName = user.getLoginName();
		Users users = userService.getUsersByUserName(userName);
		if(users!=null&&!users.getLoginName().equals("")){
			request.setAttribute("msg","用户名已存在");
			return "page/login/register";
		}else{
			String password=MD5.Encrypt(user.getPassword());
			user.setPassword(password);
			int res = userService.insert(user);
			if(res>0){
				request.setAttribute("msg", "注册成功");
				return "page/login/register";
			}else{
				request.setAttribute("msg", "注册失败，请检查后重试");
				return "page/login/register";
			}
		}
	}
	
	/**
	 * 判断用户名是否存在
	 * @param userName
	 * @return
	 */
	@ResponseBody
	@RequestMapping(value="userNameExists.do",produces = "application/text; charset=utf-8")
	public String userNameExists(HttpServletResponse response,String userName){
		System.out.println(userName);
		response.setContentType("text/plain;charset=UTF-8");
		String result = "";
		if(userName.trim().equals("")){
			result="请输入用户名";
			return result ;
		}else{
			Users user= userService.getUsersByUserName(userName);
			if(user!=null&&!user.getLoginName().equals("")){
				result="该用户名已存在";
				return result ;
			}else{
				result="该用户名可用";
				return result ;
			}
		}
	}
	
}
