package com.lyg.web.controller;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.lyg.entitys.Diary;
import com.lyg.entitys.Users;
import com.lyg.service.IDiaryService;

@Controller
@RequestMapping("diary")
public class DiaryController {
	@Autowired
	private IDiaryService diaryService;
	
	 /**
	  * 添加日记
	  * @param record
	  * @return
	  */
	@ResponseBody
	@RequestMapping("addDiary.do")
   public int addDiary(HttpSession session,Diary record){
		Users user = (Users)session.getAttribute("managerInfo");
		int result = 0;
		if(user==null){
			return result;
		}else{
			int userId = user.getId();
			Date date = new Date();
			SimpleDateFormat smf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
			String addTime = smf.format(date);
			record.setAddTime(addTime);
			record.setUserId(userId);
			result = diaryService.insertSelective(record);
			return result;
		}
		
   }
	   
	   
	/**
	 * 根据id查询
	 * @param id
	 * @return
	 */
	@ResponseBody
	@RequestMapping("selectById.do")
	   public Diary selectById(Integer id){
		   Diary diary = diaryService.selectByPrimaryKey(id);
		   return diary;
	   }
	/**
	 * 修改
	 * @param record
	 * @return
	 */
	@ResponseBody
	@RequestMapping("updateDiary.do")
	   public int updateDiary(Diary record){
		Date date = new Date();
		SimpleDateFormat smf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
		String time = smf.format(date);
		record.setUpdateTime(time);
		 int result = diaryService.updateByPrimaryKeySelective(record);
	     return result;  
	}

	/**
	 * 查询所有的
	 * @param diary
	 * @return
	 */
	@ResponseBody
	@RequestMapping("queryAllDiary.do")
	   public List<Diary> queryAllDiary(Diary diary){
		List<Diary> list = new ArrayList<Diary>();
		list = diaryService.queryAllDiary(diary);
		return list;
	   }
	
	/**
	 * 删除日记
	 * @param diaryId
	 * @return
	 */
	@ResponseBody
	@RequestMapping("deleteDiaryById.do")
	   public int  deleteDiaryById(Integer diaryId){
		   int result = diaryService.deleteDiaryById(diaryId);
		   return result;
	   }

}
