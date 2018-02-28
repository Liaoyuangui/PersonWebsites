package com.lyg.web.controller;

import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
/**
 * 个人其他信息控制器类
 * @author AISINO
 *
 */
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;

import com.lyg.entitys.PersonRestinfo;
import com.lyg.entitys.Users;
import com.lyg.service.IPersonRestinfoService;
import com.lyg.unit.StringUtils;
@Controller
@RequestMapping("personRestinfo")
public class PersonRestInfoController {
	@Autowired
	private IPersonRestinfoService personRestinfoService;
	
	/**
	 * 添加数据
	 * @param request
	 * @param session
	 * @param record
	 * @return
	 */
	@ResponseBody
	@RequestMapping("insertSelective.do")
	   public int insertSelective(HttpServletRequest request,HttpSession session, PersonRestinfo record) {
		int result = 0;
		Users user = (Users)session.getAttribute("managerInfo");
		if(user==null){
			return 0;
		}else{
			Integer userId = user.getId();
			PersonRestinfo per = new PersonRestinfo();
			per.setUserId(userId);
			List<Object> listPer = personRestinfoService.selectAllPersonRestInfo(per); //用用户id去查询，判断是否存在
			if(listPer.size()>0) {
				//如果有数据，执行修改
				Date date = new Date();
				SimpleDateFormat sfd = new SimpleDateFormat("yyyy-MM-dd");
				String updateTime = sfd.format(date);
				record.setUpdateTime(updateTime);
				record.setUserId(userId);
				result = personRestinfoService.updateByPrimaryKeySelective(record);
			}else {
				//执行添加
				Date date = new Date();
				SimpleDateFormat sfd = new SimpleDateFormat("yyyy-MM-dd");
				String addTime = sfd.format(date);
				record.setAddTime(addTime);
				record.setUserId(userId);
				result = personRestinfoService.insertSelective(record);
			}
		} 
		
		return result;
		  
	   }
	   /**
	    * 根据id查询
	    * @param id
	    * @return
	    */
	@ResponseBody
	@RequestMapping("selectPerById.do")
	   public  PersonRestinfo selectPerById(Integer id) {
		if(id==null || id==0) {
			return null;
		}
		  return personRestinfoService.selectByPrimaryKey(id);   
	   }
	    
	    /**
	     * 查询所有的
	     * @param record
	     * @return
	     */
	@ResponseBody
	@RequestMapping("selectAllPersonRestInfo.do")
	   public List<Object> selectAllPersonRestInfo(PersonRestinfo record,String userXXDD){
		  if(userXXDD!=null){
			  record.setUserId(1);
		  }
		   return personRestinfoService.selectAllPersonRestInfo(record);
	   }
	
    /**
     * 查询所有的
     * @param record
     * @return
     */
	@ResponseBody
	@RequestMapping("selectAllPerByUserId.do")
	   public List<Object> selectAllPerByUserId(HttpSession session){
		Users user = (Users)session.getAttribute("managerInfo");
		if(user==null) {
			return null;
		}else {
			PersonRestinfo per = new PersonRestinfo();
			Integer userId = user.getId();
			per.setUserId(userId);
			return personRestinfoService.selectAllPersonRestInfo(per);
		}
	   }
	
	// 0000000  图片上传 00000000
	 /**
	 * 上传轮播图1
	 * @param file  上传的文件
	 * @param request
	 * @param response
	 * @return
	 * @throws IOException
	 */
	@ResponseBody
	@RequestMapping("savePersonImg1.do")
	public Map<String, Object> savePersonImg1(@RequestParam(value="choseImg1",required=true) MultipartFile file,
	HttpServletRequest request,HttpServletResponse response) throws IOException{
		Map<String, Object> map = new HashMap<String, Object>();
		String url = "../PersonWebsitesUpload/personRestInfo";
		String fileName = StringUtils.uploadFile(request, file, url);
		System.out.println(fileName);
		map.put("src", fileName);
		return map;
	}
	/**
	 * 上传轮播图2
	 * @param file  上传的文件
	 * @param request
	 * @param response
	 * @return
	 * @throws IOException
	 */
	@ResponseBody
	@RequestMapping("savePersonImg2.do")
	public Map<String, Object> savePersonImg2(@RequestParam(value="choseImg2",required=true) MultipartFile file,
	HttpServletRequest request,HttpServletResponse response) throws IOException{
		Map<String, Object> map = new HashMap<String, Object>();
		String url = "../PersonWebsitesUpload/personRestInfo";
		String fileName = StringUtils.uploadFile(request, file, url);
		System.out.println(fileName);
		map.put("src", fileName);
		return map;
	}
	/**
	 * 上传轮播图3
	 * @param file  上传的文件
	 * @param request
	 * @param response
	 * @return
	 * @throws IOException
	 */
	@ResponseBody
	@RequestMapping("savePersonImg3.do")
	public Map<String, Object> savePersonImg3(@RequestParam(value="choseImg3",required=true) MultipartFile file,
	HttpServletRequest request,HttpServletResponse response) throws IOException{
		Map<String, Object> map = new HashMap<String, Object>();
		String url = "../PersonWebsitesUpload/personRestInfo";
		String fileName = StringUtils.uploadFile(request, file, url);
		System.out.println(fileName);
		map.put("src", fileName);
		return map;
	}
	/**
	 * 上传轮播图4
	 * @param file  上传的文件
	 * @param request
	 * @param response
	 * @return
	 * @throws IOException
	 */
	@ResponseBody
	@RequestMapping("savePersonImg4.do")
	public Map<String, Object> savePersonImg4(@RequestParam(value="choseImg4",required=true) MultipartFile file,
	HttpServletRequest request,HttpServletResponse response) throws IOException{
		Map<String, Object> map = new HashMap<String, Object>();
		String url = "../PersonWebsitesUpload/personRestInfo";
		String fileName = StringUtils.uploadFile(request, file, url);
		System.out.println(fileName);
		map.put("src", fileName);
		return map;
	}
	
	//  家乡的四张00000
	 /**
	 * 上传轮播图1
	 * @param file  上传的文件
	 * @param request
	 * @param response
	 * @return
	 * @throws IOException
	 */
	@ResponseBody
	@RequestMapping("saveJxImg1.do")
	public Map<String, Object> saveJxImg1(@RequestParam(value="chosejxImg1",required=true) MultipartFile file,
	HttpServletRequest request,HttpServletResponse response) throws IOException{
		Map<String, Object> map = new HashMap<String, Object>();
		String url = "../PersonWebsitesUpload/personRestInfo";
		String fileName = StringUtils.uploadFile(request, file, url);
		System.out.println(fileName);
		map.put("src", fileName);
		return map;
	}
	/**
	 * 上传轮播图2
	 * @param file  上传的文件
	 * @param request
	 * @param response
	 * @return
	 * @throws IOException
	 */
	@ResponseBody
	@RequestMapping("saveJxImg2.do")
	public Map<String, Object> saveJxImg2(@RequestParam(value="chosejxImg2",required=true) MultipartFile file,
	HttpServletRequest request,HttpServletResponse response) throws IOException{
		Map<String, Object> map = new HashMap<String, Object>();
		String url = "../PersonWebsitesUpload/personRestInfo";
		String fileName = StringUtils.uploadFile(request, file, url);
		System.out.println(fileName);
		map.put("src", fileName);
		return map;
	}
	/**
	 * 上传轮播图3
	 * @param file  上传的文件
	 * @param request
	 * @param response
	 * @return
	 * @throws IOException
	 */
	@ResponseBody
	@RequestMapping("saveJxImg3.do")
	public Map<String, Object> saveJxImg3(@RequestParam(value="chosejxImg3",required=true) MultipartFile file,
	HttpServletRequest request,HttpServletResponse response) throws IOException{
		Map<String, Object> map = new HashMap<String, Object>();
		String url = "../PersonWebsitesUpload/personRestInfo";
		String fileName = StringUtils.uploadFile(request, file, url);
		System.out.println(fileName);
		map.put("src", fileName);
		return map;
	}
	/**
	 * 上传轮播图4
	 * @param file  上传的文件
	 * @param request
	 * @param response
	 * @return
	 * @throws IOException
	 */
	@ResponseBody
	@RequestMapping("saveJxImg4.do")
	public Map<String, Object> saveJxImg4(@RequestParam(value="chosejxImg4",required=true) MultipartFile file,
	HttpServletRequest request,HttpServletResponse response) throws IOException{
		Map<String, Object> map = new HashMap<String, Object>();
		String url = "../PersonWebsitesUpload/personRestInfo";
		String fileName = StringUtils.uploadFile(request, file, url);
		System.out.println(fileName);
		map.put("src", fileName);
		return map;
	}

}
