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
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;

import com.lyg.entitys.Theme;
import com.lyg.entitys.Users;
import com.lyg.service.IThemeService;
import com.lyg.unit.StringUtils;
/**
 * 主题控制器类
 * @author AISINO
 *
 */
@Controller
@RequestMapping("theme")
public class ThemeController {
	@Autowired
	private IThemeService themeService;
	
    /**
     * 根据主键查询
     * @param id
     * @return
     */
	@ResponseBody
	@RequestMapping("selectByPrimaryKey.do")
   public Theme selectByPrimaryKey(Integer id) {
	   if(id==null || id==0) {
		   return null;
	   }
	   return themeService.selectByPrimaryKey(id);
   }
   /**
    * 添加
    * @param request
    * @param session
    * @param record
    * @return
    */
	@ResponseBody
	@RequestMapping("insertSelective.do")
   public int insertSelective(HttpServletRequest request,HttpSession session,Theme theme) {
	   Users user = (Users)session.getAttribute("managerInfo");
		if(user==null){
			return 0;
		}else{
			Date date = new Date();
			SimpleDateFormat sfd = new SimpleDateFormat("yyyy-MM-dd");
			String addTime = sfd.format(date);
			theme.setAddTime(addTime);
			int result = themeService.insertSelective(theme);
			return result;
		}
   }
    /**
     * 修改
     * @param request
     * @param session
     * @param theme
     * @return
     */
	@ResponseBody
	@RequestMapping("updateThemeById.do")
   public int updateThemeById(HttpServletRequest request,HttpSession session,Theme theme) {
	   Users user = (Users)session.getAttribute("managerInfo");
		if(user==null){
			return 0;
		}else{
			Date date = new Date();
			SimpleDateFormat sfd = new SimpleDateFormat("yyyy-MM-dd");
			String updateTime = sfd.format(date);
			theme.setUpdateTime(updateTime);
			int result = themeService.updateByPrimaryKeySelective(theme);
			return result;
		}
   }
  /**
   *  查询所有的
   * @param record
   * @return
   */
	@ResponseBody
	@RequestMapping("selectAlltheme.do")
   public  List<Theme> selectAlltheme(Theme record){
	   return themeService.selectAlltheme(record);
   }
   /**
    *  删除
    * @param id
    * @return
    */
	@ResponseBody
	@RequestMapping("deleteThemeById.do")
   public  int deleteThemeById(Integer id) {
	   if(id==null || id==0) {
		   return 0;
	   }
	   return themeService.deleteThemeById(id);
   }
   
    /**
     * 使用主题
     * @param id
     * @return
     */
	@ResponseBody
	@RequestMapping("startThemeById.do")
   public int startThemeById(Integer id) {
	   if(id == null || id==0) {
		   return 0;
	   }else {
		  int result = themeService.startThemeById(id); // 设置该id的主题为1
		  if(result>0) {
			  //除开该id的主题状态全部设为禁用
			  List<Theme> list = themeService.selectAllThemeCkById(id);
			  for (Theme theme : list) {
				Integer tId = theme.getId();
				Integer isType = theme.getIsStart();
				if(tId!=null && isType==1) {
					themeService.stopThemeById(tId); //禁用该主题
				}
			}
		  }else {
			  return 0;
		  }
	   }
	   return 1;
   }
    //禁用主题
   public int stopThemeById(Integer id) {
	   return 0;
   }
   
   
//   文件上传
   /**
	 * 上传主题图标
	 * @param file  上传的文件
	 * @param request
	 * @param response
	 * @return
	 * @throws IOException
	 */
	@ResponseBody
	@RequestMapping("saveThemeHeadImg.do")
	public Map<String, Object> saveThemeHeadImg(@RequestParam(value="choseIcon",required=true) MultipartFile file,
	HttpServletRequest request,HttpServletResponse response) throws IOException{
		Map<String, Object> map = new HashMap<String, Object>();
		String url = "../PersonWebsitesUpload/themeImg";
		//String path = request.getSession().getServletContext().getRealPath(url);  
		//System.out.println("path="+path);
		String fileName = StringUtils.uploadFile(request, file, url);
		System.out.println(fileName);
		map.put("src", fileName);
		return map;
	}
	
	 /**
		 * 上传轮播图1
		 * @param file  上传的文件
		 * @param request
		 * @param response
		 * @return
		 * @throws IOException
		 */
		@ResponseBody
		@RequestMapping("saveIndexLbUrl1.do")
		public Map<String, Object> saveIndexLbUrl1(@RequestParam(value="choseImg1",required=true) MultipartFile file,
		HttpServletRequest request,HttpServletResponse response) throws IOException{
			Map<String, Object> map = new HashMap<String, Object>();
			String url = "../PersonWebsitesUpload/themeImg";
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
		@RequestMapping("saveIndexLbUrl2.do")
		public Map<String, Object> saveIndexLbUrl2(@RequestParam(value="choseImg2",required=true) MultipartFile file,
		HttpServletRequest request,HttpServletResponse response) throws IOException{
			Map<String, Object> map = new HashMap<String, Object>();
			String url = "../PersonWebsitesUpload/themeImg";
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
		@RequestMapping("saveIndexLbUrl3.do")
		public Map<String, Object> saveIndexLbUrl3(@RequestParam(value="choseImg3",required=true) MultipartFile file,
		HttpServletRequest request,HttpServletResponse response) throws IOException{
			Map<String, Object> map = new HashMap<String, Object>();
			String url = "../PersonWebsitesUpload/themeImg";
			String fileName = StringUtils.uploadFile(request, file, url);
			System.out.println(fileName);
			map.put("src", fileName);
			return map;
		}
	
	

}
