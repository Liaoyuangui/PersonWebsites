package com.lyg.unit;

import java.util.ArrayList;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class ImgUtil {
	/** 
     * 从HTML源码中提取图片路径，最后以一个 String 类型的 List 返回，如果不包含任何图片，则返回一个 size=0　的List 
     * 需要注意的是，此方法只会提取以下格式的图片：.jpg|.bmp|.eps|.gif|.mif|.miff|.png|.tif|.tiff|.svg|.wmf|.jpe|.jpeg|.dib|.ico|.tga|.cut|.pic 
     * @param htmlCode HTML源码 
     * @return <img>标签 src 属性指向的图片地址的List集合 
     * @author Carl He 
     */  
    public static List<String> getImageSrc(String htmlCode) {  
        List<String> imageSrcList = new ArrayList<String>();  
        Pattern p = Pattern.compile("<img\\b[^>]*\\bsrc\\b\\s*=\\s*('|\")?([^'\"\n\r\f>]+(\\.jpg|\\.bmp|\\.eps|\\.gif|\\.mif|\\.miff|\\.png|\\.tif|\\.tiff|\\.svg|\\.wmf|\\.jpe|\\.jpeg|\\.dib|\\.ico|\\.tga|\\.cut|\\.pic)\\b)[^>]*>", Pattern.CASE_INSENSITIVE);  
        Matcher m = p.matcher(htmlCode);  
        String quote = null;  
        String src = null;  
        while (m.find()) {  
            quote = m.group(1);  
            src = (quote == null || quote.trim().length() == 0) ? m.group(2).split("\\s+")[0] : m.group(2);  
            imageSrcList.add(src);  
        }  
        return imageSrcList;  
    }  
    
    /**
     * 然后借助这个工具类进行正则匹配，但是内容中可能包含多张图片，所以我获取的肯定是一个list，但是我用的关系型数据库mysql，不能直接插入list，所以我只能将list转成
字符串插入，所以这里借助另一个工具类,完成list转成字符串，这里使用StringBuilder不用String是因为String是不可变的，自己下去查查
     * @param list
     * @param separator
     * @return
     */
    public static String listToString(List<Object> list, char separator){  
        StringBuilder sb = new StringBuilder();  
        for(int i=0; i<list.size(); i++){  
            sb.append(list.get(i)).append(separator);  
        }  
        return sb.toString().substring(0,sb.toString().length()-1);  
    }  
}
