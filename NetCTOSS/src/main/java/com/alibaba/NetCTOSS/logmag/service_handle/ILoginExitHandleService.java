package com.alibaba.NetCTOSS.logmag.service_handle;

import com.alibaba.NetCTOSS.beans.logBean.LoginExitBean;

/**
 * 登录日志 操作
 * @author Administrator
 *
 */
public interface ILoginExitHandleService {
	
	/**
	 * 保存登录日志
	 * @param log
	 * @return
	 */
	public void saveLoginExitBean(LoginExitBean log);
	
	
	
	
}
