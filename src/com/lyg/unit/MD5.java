package com.lyg.unit;

import java.io.UnsupportedEncodingException;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;

/**
 * 加密类
 * @author 
 *
 */
public class MD5 {
	/**
	 * info.setPassword(MD5.Encrypt(password)); //加密存入数据库
	 * String password =MD5.Encrypt(request.getParameter("password"));//加密
	 */
	
	private static MessageDigest digest=null;
	/**
	 * 默认16位加密
	 * @param data
	 * @return
	 */
	public synchronized static final String Encrypt(String data){
		//调用下面加密方法
		return Encrypt(data,16);
	}
	
	/**
	 * 此方法可以手动设置加密位数
	 * @param data  加密的数据
	 * @param len   加密长度
	 * @return
	 */
	private static String Encrypt(String data, int len) {
		if(digest==null){
		try {
			digest=MessageDigest.getInstance("MD5");
		} catch (NoSuchAlgorithmException e) {
			e.printStackTrace();
		}
	
		}
		if(len!=16&&len!=32) len=16;
		try {
			digest.update(data.getBytes("UTF-8"));
		} catch (UnsupportedEncodingException e) {
			e.printStackTrace();
		}
		String s=encodeHex(digest.digest());
		if(len==16){
			return s.substring(8,24);
		}
		return s;
	}
		
	
	
	private static final String encodeHex(byte[] bytes){
		int i;
		StringBuffer buf=new StringBuffer(bytes.length*2);
		for(i=0;i<bytes.length;i++){
			if(((int) bytes[i]&0xff)<0x10){
				buf.append("0");
			}
			buf.append(Long.toString((int) bytes[i]&0xff,16));
			
		}
		return buf.toString();
	}
	

}
