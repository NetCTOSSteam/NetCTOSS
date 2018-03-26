package com.alibaba.NetCTOSS.util;

import java.text.SimpleDateFormat;
import java.util.Date;

import org.apache.log4j.Logger;
import org.springframework.core.convert.converter.Converter;
import org.springframework.util.StringUtils;

public class GolbalUtilDateConverter implements Converter<String, Date> {
	private Logger log = Logger.getLogger(this.getClass());
	
	@Override
	public Date convert(String text) {
		// TODO Auto-generated method stub
		log.info(text);
		Date date = null;
		SimpleDateFormat sdf = null;
		try {
			if(StringUtils.hasLength(text)) {
				int lenth = text.trim().length();
				switch (lenth) {
				case 0:
					date = null;
					break;
				case 10:
					sdf = new SimpleDateFormat("yyyy-MM-dd");
					date = sdf.parse(text);
					break;

				default:
					sdf = new SimpleDateFormat("yyyy-MM-dd hh:mm:ss");
					date = sdf.parse(text);
					break;
				}
				log.info(date);
			}
		} catch (Exception e) {
			// TODO: handle exception
			log.error("CustomDateEditor------setAsText()", e);
		}
		return date;
	}

}
