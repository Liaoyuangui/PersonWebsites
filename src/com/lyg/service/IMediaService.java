package com.lyg.service;

import java.util.List;

import org.springframework.stereotype.Service;

import com.lyg.entitys.Media;

@Service
public interface IMediaService {
	
    //根据id查询
  public  Media selectByPrimaryKey(Integer id);
    
    //添加
  public int insertSelective(Media record);
    
    //修改
  public int updateByPrimaryKeySelective(Media record);
    
    //查询所有的
  public List<Media> selectAllMedia(Media media);
    
    //删除
  public int deleteMediaById(Integer id);

}
