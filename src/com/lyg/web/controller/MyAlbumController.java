package com.lyg.web.controller;

import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;

import com.lyg.entitys.Myalbum;
import com.lyg.entitys.Users;
import com.lyg.service.IMyAlbumPhotoService;
import com.lyg.service.IMyAlbumService;
import com.lyg.unit.StringUtils;
@Controller
@RequestMapping("myalbum")
public class MyAlbumController {
	@Autowired
	private IMyAlbumService myalbumService;
	@Autowired
	private IMyAlbumPhotoService photoService;
	  /**
	   * 添加
	   * @param record
	   * @return
	   */
	  @ResponseBody
	  @RequestMapping("addAlbum.do")
	   public int addAlbum(Myalbum record,HttpSession session){
		  Users user = (Users)session.getAttribute("managerInfo");
			int result = 0;
			if(user==null){
				return result;
			}else{
				int userId = user.getId();
				Date date = new Date();
				SimpleDateFormat smf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
				String addTime = smf.format(date);
				record.setCreateTime(addTime);
				record.setUserId(userId);
				result = myalbumService.addAlbum(record);
				return result;
			}
		   
	   }
	 /**
	  * 根据id查询
	  * @param id
	  * @return
	  */
	  @ResponseBody
	  @RequestMapping("getAlbumtById.do")
	   public Myalbum getAlbumtById(Integer id){
		  Myalbum myalbum = myalbumService.selectByPrimaryKey(id);
		  return myalbum;
	   }
      /**
       * 根据条件动态修改
       * @param record
       * @return
       */
	  @ResponseBody
	  @RequestMapping("updateAlbum.do")
	   public int updateAlbum(Myalbum record){
		   Date date = new Date();
			SimpleDateFormat smf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
			String time = smf.format(date);
			record.setUpdateTime(time);
			 int result = myalbumService.updateByPrimaryKeySelective(record);
		     return result;  
	   }

	  /**
	   * //查询所有的
	   * @param myalbum
	   * @return
	   */
	  @ResponseBody
	  @RequestMapping("queryAllMyalbum.do")
	   public List<Myalbum> queryAllMyalbum(Myalbum myalbum){
		   List<Myalbum> list = new ArrayList<Myalbum>();
			list = myalbumService.queryAllMyalbum(myalbum);
			return list;
	   }
	  
	  /**
	   * //查询所有的相册及每个相册中的总照片数
	   * @param myalbum
	   * @return
	   */
	  @ResponseBody
	  @RequestMapping("queryAllMyalbumsAndSumPhoto.do")
	   public List<Object> queryAllMyalbumsAndSumPhoto(Myalbum myalbum){
		   List<Object> list = new ArrayList<Object>();
		   List<Object> list2 = new ArrayList<>();
		   List<Myalbum> list1 = myalbumService.queryAllMyalbum(myalbum);
		  // Map<String, Integer> map = new HashMap<>();
		   for (Myalbum myalbum2 : list1) {
			   Integer albumId = myalbum2.getAlbumId();
			   int sumPhoto = photoService.selectSumPhotoByAlbumId(albumId);
			 //  map.put("sumPhoto", sumPhoto);
			   list2.add(sumPhoto);
		   }
		  list.add(list1);
		  list.add(list2);
		  return list;
	   }
	
	 /**
	 * //删除
	 * @param albumId
	 * @return
	 */
	  @ResponseBody
	  @RequestMapping("deleteAlbumById.do")
	   public int  deleteAlbumById(Integer albumId){
		   int result = myalbumService.deleteAlbumById(albumId);
		   return result;
	   }
	  
	  /**
		 * 上传相册图标
		 * @param file  上传的文件
		 * @param request
		 * @param response
		 * @return
		 * @throws IOException
		 */
		@ResponseBody
		@RequestMapping("saveAlbumIcon.do")
		public Map<String, Object> saveAlbumIcon(@RequestParam(value="chose",required=true) MultipartFile file,
		HttpServletRequest request,HttpServletResponse response) throws IOException{
			Map<String, Object> map = new HashMap<String, Object>();
			String url = "../PersonWebsitesUpload/album";
			String fileName = StringUtils.uploadFile(request, file, url);
			System.out.println(fileName);
			map.put("src", fileName);
			return map;
		}

}
