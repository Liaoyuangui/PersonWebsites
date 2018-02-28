package com.lyg.dao;

import java.util.List;

import com.lyg.entitys.Articles;

public interface ArticlesMapper {
    int deleteByPrimaryKey(Integer articlesId);

    int insert(Articles record);

    int insertSelective(Articles record);

    //根据id查询
    Articles selectByPrimaryKey(Integer articlesId);

    //动态修改
    int updateByPrimaryKeySelective(Articles record);

    //修改根据id
    int updateByPrimaryKey(Articles record);
    
    //查询所有的
    public List<Object> queryAllArticle(Articles record);
    
    //删除
    public int deleteArticles(Integer articlesId);
    
    //查询推荐文章 
    public List<Articles> queryTjArticles();
    
    //查询最新文章
    public List<Articles> queryNewArticles();
    
    //查询上一篇
    public Articles getUpArticles(Integer articlesId);
    
    //查询下一篇
    public Articles getDownArticles(Integer articlesId);
}