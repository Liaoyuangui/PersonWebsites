package com.lyg.articleclss.controller;

import java.io.IOException;
import java.io.UnsupportedEncodingException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
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

import com.lyg.entitys.ArticlesClass;
import com.lyg.entitys.Users;
import com.lyg.service.IArticlesClassService;
import com.lyg.unit.StringUtils;


@Controller
@RequestMapping("articlesClass")
public class ArticlesClassController {
    @Autowired 
	private IArticlesClassService articlesService;
    
    //查询全部
    @ResponseBody
    @RequestMapping("getAllArticlesClass.do")
    public List<Object> getAllArticlesClass(HttpServletResponse response,HttpServletRequest request,HttpSession session,ArticlesClass articlesClass) throws IOException{
    	List<Object> list = new ArrayList<Object>();
    	Users user = (Users)session.getAttribute("userInfo");
    	if(user!=null){
    		articlesClass.setUserId(user.getId());
    	}
    	list= articlesService.queryAllArticlesClass(articlesClass);
    	return list;
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
	@RequestMapping("saveArticlesClassImg.do")
	public Map<String, Object> saveUserImg(@RequestParam(value="chose",required=true) MultipartFile file,
	HttpServletRequest request,HttpServletResponse response) throws IOException{
		Map<String, Object> map = new HashMap<String, Object>();
		String url = "../PersonWebsitesUpload/articlesClassImg";
		String fileName = StringUtils.uploadFile(request, file, url);
		System.out.println(fileName);
		map.put("src", fileName);
		return map;
	}
	
    
    /**
     * 添加
     * @param response
     * @param request
     * @param session
     * @param articlesClass
     * @return
     * @throws UnsupportedEncodingException 
     */
    @ResponseBody
    @RequestMapping("addArticlesClass.do")
    public int addArticlesClass(HttpServletResponse response,HttpServletRequest request,HttpSession session,ArticlesClass articlesClass) throws UnsupportedEncodingException{
    	//managerInfo
    	request.setCharacterEncoding("utf-8");
    	response.setContentType("text/html;charset=utf-8");
    	Users mananager = (Users)session.getAttribute("managerInfo");
    	if(mananager==null){
    		return 0;
    	}else{
    		Integer id = mananager.getId();
    		articlesClass.setUserId(id);
    		Date date = new Date();
    		SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
    		String dateTime=sdf.format(date);
    		articlesClass.setCreateTime(dateTime);
    		int res = articlesService.addArticlesClass(articlesClass);
    		return res;
    	}
    	
    }
    
    /***
     * 修改
     * @param request
     * @param response
     * @param articlesClass
     * @return
     */
    @ResponseBody
    @RequestMapping("updateArticlesClass.do")
    public int updateArticlesClass(HttpServletRequest request,HttpServletResponse response,ArticlesClass articlesClass){
    	Date date = new Date();
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
		String dateTime=sdf.format(date);
		articlesClass.setUpdateTime(dateTime);
    	int res = articlesService.updateArticlesClass(articlesClass);
    	return res;
    }
    
    /**
     * 删除分类信息
     * @param request
     * @param response
     * @param classId
     * @return
     */
    @ResponseBody
    @RequestMapping("deleteArticlesClassByClassId.do")
    public int deleteArticlesClassByClassId(HttpServletRequest request,HttpServletResponse response,Integer classId){
    	int res = articlesService.deleteArticlesClass(classId);
    	return res;
    }
    
    /**
     * 根据id查询
     * @param request
     * @param response
     * @param classId
     * @return
     */
    @ResponseBody
    @RequestMapping("getArticlesClassById.do")
    public ArticlesClass getArticlesClassById(HttpServletRequest request,HttpServletResponse response,Integer classId){
    	ArticlesClass query = articlesService.queryArticlesClassById(classId);
        return query;
    }
    
    /**
     * 获取前台页面显示的分类
     * @param request
     * @param response
     * @return
     */
    @ResponseBody
    @RequestMapping("selectIndexShow.do")
    public List<ArticlesClass> selectIndexShow(HttpServletRequest request,HttpServletResponse response) {
		return articlesService.selectIndexShow();
	}
    
    
}
