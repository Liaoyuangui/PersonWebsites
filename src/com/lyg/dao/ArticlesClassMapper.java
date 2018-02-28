package com.lyg.dao;

import java.util.List;

import org.springframework.stereotype.Repository;

import com.lyg.entitys.ArticlesClass;

@Repository
public interface ArticlesClassMapper {
    int deleteByPrimaryKey(Integer classId);

    int insert(ArticlesClass record);

    int insertSelective(ArticlesClass record);

    ArticlesClass selectByPrimaryKey(Integer classId);

    int updateByPrimaryKeySelective(ArticlesClass record);

    int updateByPrimaryKey(ArticlesClass record);
    
  //获取分类信息
  	public List<Object> queryAllArticlesClass(ArticlesClass articeles);
  	
  	//删除
  	public int deleteByClassId(Integer classId);
  	
  	//查询前台页面显示的
  	List<ArticlesClass> selectIndexShow();
}