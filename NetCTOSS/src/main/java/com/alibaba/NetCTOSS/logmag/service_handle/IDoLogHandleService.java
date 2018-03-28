package com.alibaba.NetCTOSS.logmag.service_handle;

import com.alibaba.NetCTOSS.beans.logBean.DoLogBean;

/**
 * 
 * 操作日志 操作
 * @author Administrator
 *
 */
public interface IDoLogHandleService {
	
	/**
	 * 保存操作日志
	 * @param log
	 * @return
	 */
	public void saveDoLogBean(DoLogBean log);
	
	
	
}
