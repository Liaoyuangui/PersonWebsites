package com.lyg.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.lyg.dao.DiaryMapper;
import com.lyg.entitys.Diary;
import com.lyg.service.IDiaryService;

@Service
public class DiaryServiceImpl implements IDiaryService{
	@Autowired
	private DiaryMapper diaryDao;

	@Override
	public int insertSelective(Diary record) {
		// TODO Auto-generated method stub
		return diaryDao.insertSelective(record);
	}

	@Override
	public Diary selectByPrimaryKey(Integer id) {
		// TODO Auto-generated method stub
		return diaryDao.selectByPrimaryKey(id);
	}

	@Override
	public int updateByPrimaryKeySelective(Diary record) {
		// TODO Auto-generated method stub
		return diaryDao.updateByPrimaryKeySelective(record);
	}

	@Override
	public List<Diary> queryAllDiary(Diary diary) {
		// TODO Auto-generated method stub
		return diaryDao.queryAllDiary(diary);
	}

	@Override
	public int deleteDiaryById(Integer diaryId) {
		// TODO Auto-generated method stub
		return diaryDao.deleteDiaryById(diaryId);
	}

}
