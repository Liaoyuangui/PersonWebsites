package com.lyg.login.controller;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.lyg.entitys.UserRole;
import com.lyg.entitys.Users;
import com.lyg.service.IUserRoleService;
import com.lyg.service.IUserService;
import com.lyg.unit.MD5;
import com.lyg.unit.Utility;

@Controller
@RequestMapping("loginController")
public class LoginController {
    
	@Autowired
	private IUserService userService;
	@Autowired
	private IUserRoleService roleService;
	
	
	/**
	 * 用户登录
	 * @param request
	 * @param response
	 * @param session
	 * @param UserName 用户名
	 * @param password 密码
	 * @param yzm      验证码
	 * @return
	 */
	@RequestMapping("login.do")
	public String login(HttpServletRequest request,HttpServletResponse response,
			HttpSession session,String UserName,String password,String yzm){
		if(yzm!=null && !yzm.equals("")){
			//判断验证码是否正确
			String code = Utility.convertString((String)session.getAttribute("rCode"));//部分大小写
			String yzms = Utility.convertString(yzm);
			if(yzm.trim().equals("")|| !yzms.equals(code)){
				request.setAttribute("msg", "验证码输入错误");
				return "page/login/login";
			}else{
				Users users = userService.getUsersByUserName(UserName);
				if(users==null){
					request.setAttribute("msg", "没有该用户");
					return "page/login/login";
				}else{
					String pass = users.getPassword();
					String pass1 = MD5.Encrypt(password);
					//验证密码是否zhengq
					if(pass.equals(pass1)){
						//如果密码正确，判断权限
						Integer roleId = users.getRoleId();
						UserRole role = roleService.getRoleById(roleId);
						Integer userRole = role.getRolePower();
						if(userRole==1){
							//管理员
							session.setAttribute("managerInfo", users);
							return "page/managerPage/main/managerMain";
						}else if(userRole==2){
							//普通用户
							session.setAttribute("userInfo", users);
							return "page/showPage/main";
						}
						
					}else{
						request.setAttribute("msg", "密码输入错误");
						return "page/login/login";
					}
					
				}
				return "page/login/login";
			}
		}else{
			return "page/login/login";
		}
	}
	
	/**
	 * 判断验证码是否正确
	 * @param request
	 * @param response
	 * @param yzm
	 * @param session
	 * @return
	 */
	@ResponseBody
	@RequestMapping(value="IsExistCode.do",produces = "application/text; charset=utf-8")
	public String IsExistCode(HttpServletRequest request,HttpServletResponse response,String yzm,HttpSession session){
		String code = Utility.convertString((String)session.getAttribute("rCode"));//部分大小写
		String yzms = Utility.convertString(yzm);
		if(yzm.trim().equals("")|| !yzms.equals(code)){
			return "0";
		}else{
			return "1";
		}
	}
	
	/**
	 * qq登录，保存本地session
	 * @param request
	 * @param response
	 * @param session
	 * @param nickname  昵称
	 * @param figureurl 头像
	 * @return
	 */
	@ResponseBody
	@RequestMapping("saveSession.do")
	public String saveSession(HttpServletRequest request,HttpServletResponse response,HttpSession session,String nickname,String figureurl){
		Users user = new Users();
		user.setLoginName(nickname); //用户名
		user.setUserTx(figureurl);
		session.setAttribute("userInfo", user);
		return "success";
	}
	
	/**
	 * 注销登录
	 * @param session
	 * @return
	 */
	@ResponseBody
	@RequestMapping("exitLogin.do")
	public String exitLogin(HttpSession session){
		session.setAttribute("userInfo", null);
		return "success";
	}
	
}
