package com.lyg.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.lyg.dao.ArticlesMapper;
import com.lyg.entitys.Articles;
import com.lyg.service.IArticleService;
@Service
public class ArticleServiceImpl implements IArticleService {

	@Autowired
	private ArticlesMapper articlesDao;
	@Override
	public List<Object> queryAllArticle(Articles articles) {
		// TODO Auto-generated method stub
		return articlesDao.queryAllArticle(articles);
	}
	@Override
	public int addArticles(Articles articles) {
		// TODO Auto-generated method stub
		return articlesDao.insertSelective(articles);
	}
	@Override
	public int updateArticles(Articles articles) {
		// TODO Auto-generated method stub
		return articlesDao.updateByPrimaryKeySelective(articles);
	}
	@Override
	public int deleteArticles(Integer articlesId) {
		// TODO Auto-generated method stub
		return articlesDao.deleteArticles(articlesId);
	}
	@Override
	public Object queryArticlesById(Integer articlesId) {
		// TODO Auto-generated method stub
		return articlesDao.selectByPrimaryKey(articlesId);
	}
	@Override
	public List<Articles> queryTjArticles() {
		// TODO Auto-generated method stub
		return articlesDao.queryTjArticles();
	}
	@Override
	public List<Articles> queryNewArticles() {
		// TODO Auto-generated method stub
		return articlesDao.queryNewArticles();
	}
	@Override
	public Articles getUpArticles(Integer articlesId) {
		// TODO Auto-generated method stub
		return articlesDao.getUpArticles(articlesId);
	}
	@Override
	public Articles getDownArticles(Integer articlesId) {
		// TODO Auto-generated method stub
		return articlesDao.getDownArticles(articlesId);
	}

}
