package com.lyg.service;

import java.util.List;

import org.springframework.stereotype.Service;

import com.lyg.entitys.Diary;

@Service
public interface IDiaryService {
	
//根据条件插入
   public int insertSelective(Diary record);
//根据id查询
   public Diary selectByPrimaryKey(Integer id);
//根据条件动态修改
   public int updateByPrimaryKeySelective(Diary record);

//查询所有的，根据添加时间排序
   public List<Diary> queryAllDiary(Diary diary);
//删除日记
   public int  deleteDiaryById(Integer diaryId);

}
