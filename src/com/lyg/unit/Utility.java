package com.lyg.unit;

import java.text.SimpleDateFormat;
import java.util.Date;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class Utility {
	/**
	 * 实用类
	 */
	
	
	/**
	 * 写入cookie
	 * @param response
	 * @param key
	 * @param value
	 */
	
	public static void writeCookie(HttpServletResponse response,String key,String value){
		//调用下面的writeCookie方法
		writeCookie(response, key, value,-1);
	}
	/**
	 * 写入Cookie
	 * @param response
	 * @param key
	 * @param value
	 * @param i
	 */

	
	@SuppressWarnings("deprecation")
	private static void writeCookie(HttpServletResponse response, String key,
			String value,int i) {
		value=java.net.URLEncoder.encode(value);//对传进来的字符串进行编码，中文会报异常
	//	System.out.println(value);
		Cookie name =new Cookie(key, value);//创建cookie对象
		if(i>0)
			i=i*60;//设置时间
		name.setPath("/");                  //设置路径
		name.setMaxAge(i);                  //设置cookie的生命周期
		response.addCookie(name);           //添加Cookie
		
	}
	/**
	 * 删除  cookie
	 * @param response
	 * @param key
	 * @param value
	 */
	public static void deleteCookie(HttpServletResponse response,String key,String value){
		writeCookie(response, key, value,0);
		
		
	}
	/**
	 * 读取cookie值
	 * 
	 * @param request
	 * @param key
	 * @return
	 */
	
	@SuppressWarnings("deprecation")
	public static String readCookie(HttpServletRequest request,String key){
		String value="";
		Cookie [] cookie=request.getCookies(); //新建cookie数组接收cookie值
		if(cookie==null)
			return "";                         //如果没有返回空值
		for(Cookie c:cookie){                  //不然遍历输出
			if(c.getName().equals(key)){
				                               //解码后赋值给value
				value=java.net.URLDecoder.decode(c.getValue());
				break;
			}
		}
		return value;
	}
	
	
	/**
	 * 大写字母转小写
	 */
	public static  String   convertString(String str){
		if(str==null || str.equals("")) {
			return "";
		}else {
			StringBuffer   buf  =  new   StringBuffer(str.length());  
			for(int i=0;i<str.length();i++){
				char s=str.charAt(i);
				//如果是大写字母转成小写
				if(s>='A'&&s<='Z'){
					s+=32;
					buf.append(s);
				}else{
					//不是字母直接添加到buf中
				    buf.append(s);
				}
			}
			
			return buf.toString();
		}
	}
	
	
	/**
	 * 获取上传文件的后缀名
	 */
	
  public static String UploadAfterName(String header){
	//form-data; name="file"; filename="666.jpg" 传进来数据的格式
	  String afterName="";
	  String [] str1=header.split(";");  //按分号分割0 , 1 ,2(filename在在数组中下标为2,如上的文件str1[2]为filename="666.jpg")
	  String [] str2=str1[2].split("="); //按等号分割    str2[1]的值为"666.jpg"
	  //下一步得到得到结果fileName=666.jpg
      String fileName=str2[1].substring(1,str2[1].length()-1);// 去掉双引号就拿到文件名
      String [] str3=fileName.split("\\."); //按点号分割拿到后缀名 
     //String fileNames=str2[1].substring(str2[1].lastIndexOf("\\")+1).replaceAll("\"", "");
	  
	  afterName=str3[1];
	  return afterName;
  }
  
  //获取后缀名
  public static String afterName (String fileName){
	  String [] str= fileName.split("\\.");
	  String afterName = str[str.length-1];
	  return afterName;
  }
  
  /**
   * 修改上传的文件名
   * @return
   */
  public static String getFileName(){
	  //以系统时间来命名
	  Date date=new Date();
	  SimpleDateFormat sim=new SimpleDateFormat("yyyyMMddHHmmss");
	  String fileName = sim.format(date);
	  //System.out.println(fileName);
	  return fileName;
	  
	  
  }
  
 public static void main(String[] args) {
	//String string="form-data; name='file'; filename='666.jpg'";
	//UploadAfterName(string);
	//getFileName();
	// String name = afterName("111125464.jpg");
	// System.out.println(name);
 }
}