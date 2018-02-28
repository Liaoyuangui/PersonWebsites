package com.lyg.web.controller;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.lyg.entitys.MyalbumPhoto;
import com.lyg.service.IMyAlbumPhotoService;
import com.lyg.unit.ImgUtil;
/**
 * 相册照片控制器
 * @author 无心
 *
 */
@Controller
@RequestMapping("myAlbumPhoto")
public class MyAlbumPhotoController {
	@Autowired
	private IMyAlbumPhotoService  photoService;
	
	/**
	 * 批量添加照片
	 * @param content
	 * @return
	 */
	  @ResponseBody
	  @RequestMapping("insersBatch.do")
	   public  int  insersBatch(String content,Integer xcId){
		    List list = ImgUtil.getImageSrc(content);  
			List<String> strList = new ArrayList<>();
			List<MyalbumPhoto> photoList = new ArrayList<MyalbumPhoto>();
			String picturePath = ImgUtil.listToString(list, ','); 
			//得到一个字符串，
			//格式：../../../ServiceManagerUpload/ueditor/jsp/upload/image/20171019/1508395394681039351.jpg,../../../ServiceManagerUpload/ueditor/jsp/upload/image/20171019/1508395394690084478.jpg,../../../ServiceManagerUpload/ueditor/jsp/upload/image/20171019/1508395394701054318.jpg
			System.out.println(picturePath);
			String str[] = picturePath.split(",");
			for(int i=0;i<str.length;i++){
				strList.add(str[i]);
			}
			for (int i = 0; i < strList.size(); i++) {
				MyalbumPhoto photo = new MyalbumPhoto();
				String photoUrl = strList.get(i); //得到照片路径
				photo.setPhotoUrl(photoUrl);
				Date date = new Date();
				SimpleDateFormat smf = new SimpleDateFormat("yyyy-MM-dd");
				String addTime = smf.format(date);
				photo.setCreateTime(addTime); //添加时间
				photo.setAlbumId(xcId);       //相册id
				photoList.add(photo);
			}
			
			//执行批量插入的方法即可
			//http://blog.csdn.net/zljjava/article/details/47038143
			int result = photoService.insersBatch(photoList);
		   return result;
	   }
	    
	   /**
	    * 删除
	    * @param photoId
	    * @return
	    */
	  @ResponseBody
	  @RequestMapping("deletePhotoById.do")
	   public  int  deletePhotoById(Integer photoId){
		   return photoService.deletePhotoById(photoId);
	   }
	    
	  /**
	   * 查询相册下的所有照片
	   * @param albumId
	   * @return
	   */
	  @ResponseBody
	  @RequestMapping("selectAllPhotoByAlbumId.do")
	   public List<MyalbumPhoto> selectAllPhotoByAlbumId(Integer albumId){
		   List<MyalbumPhoto> list = new ArrayList<MyalbumPhoto>();
		   if(albumId==null){
			   return null;
		   }else{
			   list = photoService.selectAllPhotoByAlbumId(albumId);
		   }
		   return list;
	   }
	  /**
	   * 查询所有的除首页展示的除外
	   * @param record
	   * @return
	   */
	  @ResponseBody
	  @RequestMapping("selectAllPhotoCKphotoId.do")
		public List<MyalbumPhoto> selectAllPhotoCKphotoId(Integer photoId, Integer albumId) {
			MyalbumPhoto photo = new MyalbumPhoto();
			if(photoId!=null){
				photo.setPhotoId(photoId);
			}else{
				return null;
			}
			if(albumId!=null){
				photo.setAlbumId(albumId);
			}else{
				return null;
			}
			
			List<MyalbumPhoto> list = photoService.selectAllPhotoCKphotoId(photo);
		    return list;
		}

		/**
		 * 根据id查询
		 * @param photoId
		 * @return
		 */
	  @ResponseBody
	  @RequestMapping("selectPhotoById.do")
		public MyalbumPhoto selectPhotoById(Integer photoId) {
			MyalbumPhoto photo = new MyalbumPhoto();
			if(photoId!=null){
				photo = photoService.selectPhotoById(photoId);
			}else{
				return null;
			}
			return photo;
		}

}
