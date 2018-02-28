package com.lyg.service;

import java.util.List;

import org.springframework.stereotype.Service;

import com.lyg.entitys.ArticlesClass;

@Service
public interface IArticlesClassService {
   
	//获取分类信息
	public List<Object> queryAllArticlesClass(ArticlesClass articeles);
	
	//添加
	public int addArticlesClass(ArticlesClass articeles);
	
	//修改
	public int updateArticlesClass(ArticlesClass articeles);
	
	//根据id查询
	public ArticlesClass queryArticlesClassById(Integer classId);
	
	//删除
	public int deleteArticlesClass(Integer classId);
	
	//查询前台页面显示的
    public	List<ArticlesClass> selectIndexShow();
	
}
