package com.alibaba.NetCTOSS.util;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

public class MyDateUtil {

	
	
	
	/**
	 *  时间 转 字符串
	 * @param date 时间数据
	 * @param da 显示格式 例如 "yyyy-MM-dd"
	 * @return
	 */
	public static String DataToString(Date date,String da) {
		SimpleDateFormat df = new SimpleDateFormat(da);
		
		return df.format(date);
		
	}
	
	/**
	 * String 转 时间
	 * @param data string的时间数据 例如"2017-01-01"  
	 * @param ty 与之对应的格式 "yyyy-MM-dd"
	 * @return
	 */
	public static Date StringToDate(String data,String ty) {
		SimpleDateFormat sdf = new SimpleDateFormat(ty); 
		Date date = null;
		try {
			date = sdf.parse(data);
		} catch (ParseException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}//String-->Date 
		return date;
		
	}
//	public static void main(String[] args) {
//		Date date1 = new Date();
//		System.out.println(DataToString(new Date(), "yyyy-MM-dd"));
//	}
}
