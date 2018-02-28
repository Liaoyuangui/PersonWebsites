package com.lyg.unit;

import java.io.File;
import java.util.UUID;

import javax.servlet.http.HttpServletRequest;

import org.springframework.web.multipart.MultipartFile;
public class StringUtils {
	
	/**
	 * 获取文件的后缀名
	 * @param filename
	 * @return
	 */
	 public static String getExtensionName(String filename) {   
	        if ((filename != null) && (filename.length() > 0)) {   
	            int dot = filename.lastIndexOf('.');   
	            if ((dot >-1) && (dot < (filename.length() - 1))) {   
	                return filename.substring(dot + 1);   
	            }   
	        }   
	        return filename;   
	    }   
	 
	 /**
	  * 文件上传
	  * @param request
	  * @param file
	  * @param uploadDir
	  * @return
	  */
	 public static String uploadFile(HttpServletRequest request,MultipartFile file,String uploadDir){
		    System.out.println("开始");  
	        String path = request.getSession().getServletContext().getRealPath(uploadDir); 
	        String ylfileName = file.getOriginalFilename(); 
	        String  fileName = UUID.randomUUID().toString()+"."+getExtensionName(ylfileName);
	       
//	        String fileName = new Date().getTime()+".jpg";  
	        System.out.println(path);  
	        File targetFile = new File(path, fileName);  
	        if(!targetFile.exists()){  
	            targetFile.mkdirs();  
	        }  
	        //保存  
	        try {  
	            file.transferTo(targetFile);  
	        } catch (Exception e) {  
	            e.printStackTrace();  
	        }  
	        //
		 return request.getContextPath()+"/"+uploadDir+"/"+fileName;
	 }
	 
	 


}
