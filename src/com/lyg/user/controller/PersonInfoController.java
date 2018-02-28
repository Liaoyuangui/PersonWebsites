package com.lyg.user.controller;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.HashMap;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import com.lyg.entitys.PersonInfo;
import com.lyg.entitys.Users;
import com.lyg.service.IUserInfoService;
import com.lyg.service.IUserService;
import com.lyg.unit.MD5;
import com.lyg.unit.StringUtils;
import com.lyg.unit.Utility;

@RestController
@RequestMapping("users")
public class PersonInfoController {
	
	@Autowired
	private IUserInfoService  personInfoService;
	@Autowired
	private IUserService  userService;
	
	/**
	 * 上传头像
	 * @param file
	 * @param classesId
	 * @param request
	 * @return
	 */
	@ResponseBody
	@RequestMapping("uploadFile.do")
	public String uploadFile(@RequestParam(value="choseTx",required=true) MultipartFile file,
			Long classesId,HttpServletRequest request){
		 String res = "";
		 //文件上传的路径
		 String path = request.getSession().getServletContext().getRealPath("/")+"upload\\userTx\\";  
		 System.out.println(path);
	     String fileName = file.getOriginalFilename();  //文件名
	     String newFileName = Utility.getFileName();  // 新文件名
	     //如果文件不存在则创建
	     File f = new File(path);
	     if(!f.exists()){
	    	 f.mkdirs();
	     }
	     String afterName = Utility.afterName(fileName);//得到后缀名
	     String uploadFile = path+newFileName+afterName;
	     if (!file.isEmpty()) {  
	            try {  
	                FileOutputStream fos = new FileOutputStream(uploadFile);  
	                InputStream in = file.getInputStream();  
	                int b = 0;  
	                while ((b = in.read()) != -1) {  
	                    fos.write(b);  
	                }  
	                fos.close();  
	                in.close();  
	            } catch (Exception e) {  
	                e.printStackTrace();  
	            }  
	        }  
	        
	        System.out.println("上传图片到:" + uploadFile);  
	        //把upladfile 保存到数据库中  
	        PersonInfo personInfo = new PersonInfo();
	        personInfo.setPersonTx(uploadFile);
	        int result = personInfoService.uploadImage(personInfo);
	        if(result>0){
	        	res="src:"+uploadFile;
	        }
		
		return res;
	}
	/**
	 * 上传头像
	 * @param file  上传的文件
	 * @param request
	 * @param response
	 * @return
	 * @throws IOException
	 */
	@ResponseBody
	@RequestMapping("saveUserImg.do")
	public Map<String, Object> saveUserImg(@RequestParam(value="choseTx",required=true) MultipartFile file,
	HttpServletRequest request,HttpServletResponse response) throws IOException{
		Map<String, Object> map = new HashMap<String, Object>();
		String url = "../PersonWebsitesUpload/userImg";
		String fileName = StringUtils.uploadFile(request, file, url);
		System.out.println(fileName);
		map.put("src", fileName);
		return map;
	}
	
	/**
	 * 修改或插入个人信息，有就修改，没有就插入
	 * @param respose
	 * @param request
	 * @param session
	 * @param map
	 * @param personInfo
	 * @return
	 */
	@ResponseBody
	@RequestMapping("insertOrUpdatePersonInfo.do")
	public Map<String, Object> insertOrUpdatePersonInfo(HttpServletResponse respose,HttpServletRequest request,HttpSession session, PersonInfo personInfo){
		Users user = (Users)session.getAttribute("managerInfo");
		Map<String, Object> map = new HashMap<String, Object>();
		if(user!=null){
			Integer userId = user.getId();
			personInfo.setUserId(userId);
			PersonInfo person = personInfoService.selectByUserId(userId);
			if(person==null || person.getPersonSex().equals("")){
				//没有信息，插入
				int res=personInfoService.insertSelective(personInfo);
				if(res>0){
					map.put("errcode", "0");
					map.put("res", "保存成功");
				}else{
					map.put("errcode", "1");
					map.put("res", "保存失败");
				}
			}else{
				//有信息，修改
				int res = personInfoService.updateByUserId(personInfo);
				if(res>0){
					map.put("errcode", "0");
					map.put("res", res);
				}else{
					map.put("errcode", "1");
					map.put("res", "保存失败");
				}
			}
			
		}else{
			map.put("errcode", "1");
			map.put("res", "请先登录");
		}
		return map;
	}
	/**
	 * 获取当前用户信息
	 * @param respose
	 * @param request
	 * @param session
	 * @return
	 */
	@ResponseBody
	@RequestMapping("getPonserInfoByUserId.do")
	public Map<String, Object> getPonserInfoByUserId(HttpServletResponse respose,HttpServletRequest request,HttpSession session){
		Map<String, Object> map = new HashMap<String, Object>();
		Users user = (Users)session.getAttribute("managerInfo");
		if(user != null){
			Integer userId = user.getId();
			PersonInfo personInfo = personInfoService.selectByUserId(userId);
			map.put("result", personInfo);
		}else{
			map.put("errcode", "1");
			map.put("result", "请先登录");
		}
		
		return map;
	}
	
	/**
	 * 连表查询用户个人信息
	 * @param userId
	 * @param session
	 * @param response
	 * @return
	 */
	@ResponseBody
	@RequestMapping("selectUserAndPersonByUserId.do")
	public Map<String, Object> selectUserAndPersonByUserId(String userId ,HttpSession session,HttpServletResponse response){
		Map<String, Object> map = new HashMap<String, Object>();
		Integer userid = Integer.parseInt(userId);
		Object query = personInfoService.selectUserAndPersonByUserId(userid);
		map.put("result", query);
		return map;
	}
	
	/**
	 * 修改密码
	 * @param ymm  原密码
	 * @param xmm  新密码
	 * @return
	 */
	@ResponseBody
	@RequestMapping("setPassword.do")
	public Map<String, String> setPassword(String ymm,String xmm,HttpSession session){
		Map<String, String> map = new HashMap<>();
		Users user = (Users)session.getAttribute("managerInfo");
		if(user == null) {
			map.put("msg", "请先登录！");
		}else {
			String pass = user.getPassword();
			String pass1 = MD5.Encrypt(ymm);
			if(!pass.equals(pass1)) {
				map.put("msg", "原密码输入错误！");
			}else {
				//修改
				user.setPassword(MD5.Encrypt(xmm));
				int result = userService.updateByPrimaryKeySelective(user);
				if(result>0) {
					map.put("msg", "修改成功！！！");
				}else {
					map.put("msg", "修改失败！！！");
				}
			}
		}
		
		return map;
	}

}
