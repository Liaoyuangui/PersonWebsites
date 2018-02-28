package com.lyg.service;

import java.util.List;

import org.springframework.stereotype.Service;

import com.lyg.entitys.Articles;

@Service
public interface IArticleService {
   //获取所有的
	public List<Object> queryAllArticle(Articles articles);
	
   //添加
	public int addArticles(Articles articles);
	
	//修改
	public int updateArticles(Articles articles);
	
	//删除
	public int deleteArticles(Integer articlesId);
	
	//根据id获取单条数据
	public Object queryArticlesById(Integer articlesId);
	
	 //查询推荐文章 
    public List<Articles> queryTjArticles();
    
    //查询最新文章
    public List<Articles> queryNewArticles();
    
    
    //查询上一篇
    public Articles getUpArticles(Integer articlesId);
    
    //查询下一篇
    public Articles getDownArticles(Integer articlesId);
	
}
