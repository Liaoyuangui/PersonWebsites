package com.lyg.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.lyg.dao.ThemeMapper;
import com.lyg.entitys.Theme;
import com.lyg.service.IThemeService;
@Service
public class ThemeServiceImpl implements IThemeService {
	@Autowired
	private ThemeMapper themeDao;

	@Override
	public Theme selectByPrimaryKey(Integer id) {
		// TODO Auto-generated method stub
		return themeDao.selectByPrimaryKey(id);
	}

	@Override
	public int insertSelective(Theme record) {
		// TODO Auto-generated method stub
		return themeDao.insertSelective(record);
	}

	@Override
	public int updateByPrimaryKeySelective(Theme record) {
		// TODO Auto-generated method stub
		return themeDao.updateByPrimaryKeySelective(record);
	}

	@Override
	public List<Theme> selectAlltheme(Theme record) {
		// TODO Auto-generated method stub
		return themeDao.selectAlltheme(record);
	}

	@Override
	public int deleteThemeById(Integer id) {
		// TODO Auto-generated method stub
		return themeDao.deleteThemeById(id);
	}

	@Override
	public int startThemeById(Integer id) {
		// TODO Auto-generated method stub
		return themeDao.startThemeById(id);
	}

	@Override
	public int stopThemeById(Integer id) {
		// TODO Auto-generated method stub
		return themeDao.stopThemeById(id);
	}

	@Override
	public List<Theme> selectAllThemeCkById(Integer id) {
		// TODO Auto-generated method stub
		return themeDao.selectAllThemeCkById(id);
	}

}
