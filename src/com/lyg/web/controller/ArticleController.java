package com.lyg.web.controller;

import java.io.IOException;
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

import com.lyg.entitys.Articles;
import com.lyg.entitys.Users;
import com.lyg.service.IArticleService;
import com.lyg.unit.StringUtils;


@Controller
@RequestMapping("articles")
public class ArticleController {
	@Autowired
	private IArticleService articlesService;
	
	/**
	 * 添加
	 * @param request
	 * @param response
	 * @param session
	 * @param articles
	 * @return
	 */
	@ResponseBody
	@RequestMapping("addArticles.do")
	public int addArticles(HttpServletRequest request,HttpServletResponse response,HttpSession session,Articles articles){
		Users user = (Users)session.getAttribute("managerInfo");
		if(user==null){
			return 0;
		}else{
			Date date = new Date();
			SimpleDateFormat sfd = new SimpleDateFormat("yyyy-MM-dd");
			String addTime = sfd.format(date);
			articles.setAddTime(addTime);
			Integer id = user.getId();
			articles.setUserId(id);
			int result = articlesService.addArticles(articles);
			return result;
		}
	}
	
	/**
	 * 查询所有的文章
	 * @param request
	 * @param response
	 * @param session
	 * @param articles
	 * @return
	 */
	@ResponseBody
	@RequestMapping("queryAllArticles.do")
	public List<Object> queryAllArticles(HttpServletRequest request,HttpServletResponse response,HttpSession session,Articles articles,Integer classId){
		/*Users user = (Users)session.getAttribute("managerInfo");
		List<Object> list = new ArrayList<Object>();
		if(user==null){
			return null;
		}else{
			list = articlesService.queryAllArticle(articles);
			return list;
		}*/
		List<Object> list = new ArrayList<Object>();
		if(classId != null) {
			articles.setClassId(classId);
		}
		list = articlesService.queryAllArticle(articles);
		return list;
	}
	
	/**
	 * 修改
	 * @param request
	 * @param response
	 * @param session
	 * @param articles
	 * @return
	 */
	@ResponseBody
	@RequestMapping("updateArticles.do")
	public int updateArticles(HttpServletRequest request,HttpServletResponse response,HttpSession session,Articles articles){
		Users user = (Users)session.getAttribute("managerInfo");
		if(user==null){
			return 0;
		}else{
			Date date = new Date();
			SimpleDateFormat sfd = new SimpleDateFormat("yyyy-MM-dd");
			String addTime = sfd.format(date);
			articles.setUpdateTime(addTime);
			Integer id = user.getId();
			articles.setUserId(id);
			int result = articlesService.updateArticles(articles);
			return result;
		}
	}
	
	/**
	 * 根据id查询
	 * @param request
	 * @param response
	 * @param articlesId
	 * @return
	 */
	@ResponseBody
	@RequestMapping("queryArticlesById.do")
	public Object queryArticlesById(HttpServletRequest request,HttpServletResponse response,Integer articlesId){
		if(articlesId==null || articlesId==0){
			return null;
		}
		Object query = articlesService.queryArticlesById(articlesId);
		return query;
	}
	
	/**
	 * 根据id删除
	 * @param request
	 * @param response
	 * @param articlesId
	 * @return
	 */
	@ResponseBody
	@RequestMapping("deleteArticlesById.do")
	public int deleteArticlesById(HttpServletRequest request,HttpServletResponse response,Integer articlesId){
		if(articlesId==null || articlesId==0){
			return 0;
		}
		int del = articlesService.deleteArticles(articlesId);
		return del;
	}
	
	 /**
	  * 查询推荐文章 
	  * @param request
	  * @param response
	  * @return
	  */
	@ResponseBody
	@RequestMapping("queryTjArticles.do")
    public List<Articles> queryTjArticles(HttpServletRequest request,HttpServletResponse response){
    	 List<Articles> list = new ArrayList<Articles>();
    	 list = articlesService.queryTjArticles();
    	 return list;
    }
    
    /**
     * 查询最新的文章
     * @param request
     * @param response
     * @return
     */
	@ResponseBody
	@RequestMapping("queryNewArticles.do")
    public List<Articles> queryNewArticles(HttpServletRequest request,HttpServletResponse response){
    	 List<Articles> list = new ArrayList<Articles>();
	   	 list = articlesService.queryNewArticles();
	   	 return list;
    }
	
	 /**
	  * //查询上一篇
	  * @param articlesId
	  * @return
	  */
	@ResponseBody
	@RequestMapping("getUpArticles.do")
    public Articles getUpArticles(Integer articlesId){
    	if(articlesId==null || articlesId==0){
    		return null;
    	}
    	Articles upArticles = articlesService.getUpArticles(articlesId);
    	return upArticles;
    }
    
    /**
     * //查询下一篇
     * @param articlesId
     * @return
     */
	@ResponseBody
	@RequestMapping("getDownArticles.do")
    public Articles getDownArticles(Integer articlesId){
    	if(articlesId==null || articlesId==0){
    		return null;
    	}
    	Articles upArticles = articlesService.getDownArticles(articlesId);
    	return upArticles;
    }
	
	/**
	 * 上传图标
	 * @param file  上传的文件
	 * @param request
	 * @param response
	 * @return
	 * @throws IOException
	 */
	@ResponseBody
	@RequestMapping("saveArticlesIcon.do")
	public Map<String, Object> saveArticlesIcon(@RequestParam(value="choseIcon",required=true) MultipartFile file,
	HttpServletRequest request,HttpServletResponse response) throws IOException{
		Map<String, Object> map = new HashMap<String, Object>();
		String url = "../PersonWebsitesUpload/articlesImg";
		//String path = request.getSession().getServletContext().getRealPath(url);  
		//System.out.println("path="+path);
		String fileName = StringUtils.uploadFile(request, file, url);
		System.out.println(fileName);
		map.put("src", fileName);
		return map;
	}
	
	/**
	 * 正文图片1
	 * @param file  上传的文件
	 * @param request
	 * @param response
	 * @return
	 * @throws IOException
	 */
	@ResponseBody
	@RequestMapping("saveArticlesContentImg1.do")
	public Map<String, Object> saveArticlesContentImg1(@RequestParam(value="choseImg1",required=true) MultipartFile file,
	HttpServletRequest request,HttpServletResponse response) throws IOException{
		Map<String, Object> map = new HashMap<String, Object>();
		String url = "../PersonWebsitesUpload/articlesImg";
		String fileName = StringUtils.uploadFile(request, file, url);
		System.out.println(fileName);
		map.put("src", fileName);
		return map;
	}
	
	/**
	 * 正文图片2
	 * @param file  上传的文件
	 * @param request
	 * @param response
	 * @return
	 * @throws IOException
	 */
	@ResponseBody
	@RequestMapping("saveArticlesContentImg2.do")
	public Map<String, Object> saveArticlesContentImg2(@RequestParam(value="choseImg2",required=true) MultipartFile file,
	HttpServletRequest request,HttpServletResponse response) throws IOException{
		Map<String, Object> map = new HashMap<String, Object>();
		String url = "../PersonWebsitesUpload/articlesImg";
		String fileName = StringUtils.uploadFile(request, file, url);
		System.out.println(fileName);
		map.put("src", fileName);
		return map;
	}
	/**
	 * 正文图片3
	 * @param file  上传的文件
	 * @param request
	 * @param response
	 * @return
	 * @throws IOException
	 */
	@ResponseBody
	@RequestMapping("saveArticlesContentImg3.do")
	public Map<String, Object> saveArticlesContentImg3(@RequestParam(value="choseImg3",required=true) MultipartFile file,
	HttpServletRequest request,HttpServletResponse response) throws IOException{
		Map<String, Object> map = new HashMap<String, Object>();
		String url = "../PersonWebsitesUpload/articlesImg";
		String fileName = StringUtils.uploadFile(request, file, url);
		System.out.println(fileName);
		map.put("src", fileName);
		return map;
	}
	
	/**
	 * 正文图片4
	 * @param file  上传的文件
	 * @param request
	 * @param response
	 * @return
	 * @throws IOException
	 */
	@ResponseBody
	@RequestMapping("saveArticlesContentImg4.do")
	public Map<String, Object> saveArticlesContentImg4(@RequestParam(value="choseImg4",required=true) MultipartFile file,
	HttpServletRequest request,HttpServletResponse response) throws IOException{
		Map<String, Object> map = new HashMap<String, Object>();
		String url = "../PersonWebsitesUpload/articlesImg";
		String fileName = StringUtils.uploadFile(request, file, url);
		System.out.println(fileName);
		map.put("src", fileName);
		return map;
	}
	
	/**
	 * 正文图片5
	 * @param file  上传的文件
	 * @param request
	 * @param response
	 * @return
	 * @throws IOException
	 */
	@ResponseBody
	@RequestMapping("saveArticlesContentImg5.do")
	public Map<String, Object> saveArticlesContentImg5(@RequestParam(value="choseImg5",required=true) MultipartFile file,
	HttpServletRequest request,HttpServletResponse response) throws IOException{
		Map<String, Object> map = new HashMap<String, Object>();
		String url = "../PersonWebsitesUpload/articlesImg";
		String fileName = StringUtils.uploadFile(request, file, url);
		System.out.println(fileName);
		map.put("src", fileName);
		return map;
	}

}
