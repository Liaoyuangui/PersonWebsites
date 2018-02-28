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

import com.lyg.entitys.Media;
import com.lyg.entitys.Users;
import com.lyg.service.IMediaService;
import com.lyg.unit.StringUtils;

@Controller
@RequestMapping("media")
public class MediaController {
	
	@Autowired
	private IMediaService mediaService;
	
   /**
    * 根据id查询
    * @param request
    * @param id
    * @return
    */
	@ResponseBody
	@RequestMapping("selectById.do")
  public  Media selectById(HttpServletRequest request,Integer id) {
      if(id==null||id==0) {
    	  return null;
      }else {
    	  Media media = mediaService.selectByPrimaryKey(id);
    	  return media;
      }
  }
    
    /**
     * 添加
     * @param request
     * @param session
     * @param media
     * @param mName
     * @return
     */
  @ResponseBody
  @RequestMapping("addMedia.do")
  public int addMedia(HttpServletRequest request,HttpSession session,Media media,String mName,Integer isType) {
	  Users user = (Users)session.getAttribute("managerInfo");
		if(user==null){
			return 0;
		}else{
			Date date = new Date();
			SimpleDateFormat sfd = new SimpleDateFormat("yyyy-MM-dd");
			String addTime = sfd.format(date);
			media.setAddTime(addTime);
			if(isType==1) {
				media.setIsMusic(1);  //是音频
				media.setIsMovie(0);
			}
			if(isType==2) {
				media.setIsMusic(0);  //是视频
				media.setIsMovie(1);
			}
			
			media.setMediaName(mName);
			int result = mediaService.insertSelective(media);
			return result;
		}
  }
    
    /**
     * 修改
     * @param request
     * @param record
     * @return
     */
  @ResponseBody
  @RequestMapping("updateMediaById.do")
  public int updateMediaById(HttpServletRequest request,Media record) {
	  int result = 0;
	  result = mediaService.updateByPrimaryKeySelective(record);
	  return result;  
  }
    
   /**
    * 查询所有的
    * @param request
    * @param media
    * @return
    */
  @ResponseBody
  @RequestMapping("selectAllMedia.do")
  public List<Media> selectAllMedia(HttpServletRequest request,Media media){
	  List<Media> list = new ArrayList<>();
	  list = mediaService.selectAllMedia(media);
	  return list;
  }
    
    /**
     * 删除
     * @param request
     * @param id
     * @return
     */
  @ResponseBody
  @RequestMapping("deleteMediaById.do")
  public int deleteMediaById(HttpServletRequest request,Integer id) {
	  if(id==null || id==0) {
		  return 0;
	  }
	  return mediaService.deleteMediaById(id);
  }
  
  /**
	 * 上传图标
	 * @param file  上传的文件
	 * @param request
	 * @param response
	 * @return
	 * @throws IOException
	 */
	@ResponseBody
	@RequestMapping("saveMediaIcon.do")
	public Map<String, Object> saveMediaIcon(@RequestParam(value="choseIcon",required=true) MultipartFile file,
	HttpServletRequest request,HttpServletResponse response) throws IOException{
		Map<String, Object> map = new HashMap<String, Object>();
		String url = "../PersonWebsitesUpload/media/mediaIcon";
		//String path = request.getSession().getServletContext().getRealPath(url);  
		//System.out.println("path="+path);
		String fileName = StringUtils.uploadFile(request, file, url);
		System.out.println(fileName);
		map.put("src",fileName);
		return map;
	}
	
	/**
	 * 上传媒体文件
	 * @param file  上传的文件
	 * @param request
	 * @param response
	 * @return
	 * @throws IOException
	 */
	@ResponseBody
	@RequestMapping("saveMedia.do")
	public Map<String, Object> saveMedia(@RequestParam(value="choseMedia",required=true) MultipartFile file,
	HttpServletRequest request,HttpServletResponse response) throws IOException{
		Map<String, Object> map = new HashMap<String, Object>();
		String url = "../PersonWebsitesUpload/media";
		//String path = request.getSession().getServletContext().getRealPath(url);  
		//System.out.println("path="+path);
		String fileName = StringUtils.uploadFile(request, file, url);
		System.out.println(fileName);
		map.put("src", file.getOriginalFilename());
		map.put("url", fileName);
		return map;
	}

}
