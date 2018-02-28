package com.lyg.dao;

import java.util.List;

import org.springframework.stereotype.Repository;

import com.lyg.entitys.Diary;

@Repository
public interface DiaryMapper {
    int deleteByPrimaryKey(Integer id);

    int insert(Diary record);
//根据条件插入
    int insertSelective(Diary record);
//根据id查询
    Diary selectByPrimaryKey(Integer id);
//根据条件动态修改
    int updateByPrimaryKeySelective(Diary record);

//查询所有的，根据添加时间排序
    List<Diary> queryAllDiary(Diary diary);
//删除日记
    int  deleteDiaryById(Integer diaryId);
    
    int updateByPrimaryKey(Diary record);
    
    
}