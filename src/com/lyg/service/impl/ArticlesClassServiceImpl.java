package com.lyg.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.lyg.dao.ArticlesClassMapper;
import com.lyg.entitys.ArticlesClass;
import com.lyg.service.IArticlesClassService;

@Service
public class ArticlesClassServiceImpl implements IArticlesClassService {
  
	@Autowired
	private ArticlesClassMapper articlesDao;
	
	@Override
	public List<Object> queryAllArticlesClass(ArticlesClass articeles) {
		return articlesDao.queryAllArticlesClass(articeles);
	}

	@Override
	public int addArticlesClass(ArticlesClass articeles) {
		// TODO Auto-generated method stub
		return articlesDao.insertSelective(articeles);
	}

	@Override
	public int updateArticlesClass(ArticlesClass articeles) {
		// TODO Auto-generated method stub
		return articlesDao.updateByPrimaryKeySelective(articeles);
	}

	@Override
	public ArticlesClass queryArticlesClassById(Integer classId) {
		// TODO Auto-generated method stub
		return articlesDao.selectByPrimaryKey(classId);
	}

	@Override
	public int deleteArticlesClass(Integer classId) {
		// TODO Auto-generated method stub
		return articlesDao.deleteByClassId(classId);
	}

	@Override
	public List<ArticlesClass> selectIndexShow() {
		// TODO Auto-generated method stub
		return articlesDao.selectIndexShow();
	}

}
