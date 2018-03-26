package com.alibaba.NetCTOSS.util;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

public class DateUtil {

	/**
	 * 得到当前的时间
	 * @param da 需要的时间格式 例如 yyyy-MM-dd hh:mm:ss
	 * @return
	 */
	public static Date getNewData(String da) {
		Date date = new Date(System.currentTimeMillis());
		
		return updateData(date,da);
	}
	
	/**
	 * 时间转换 格式
	 * @param da 需要的时间格式 例如 yyyy-MM-dd hh:mm:ss
	 * @param date 时间数据
	 * @return
	 */
	public static Date updateData(Date date,String da) {
		SimpleDateFormat df = new SimpleDateFormat(da);
		
		Date d = null;
		try {
			d = df.parse(df.format(date));
		} catch (ParseException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return d;
	}
	
	
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
}
