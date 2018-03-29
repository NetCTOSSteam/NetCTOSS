package com.alibaba.NetCTOSS.logmag.mapper_demand;

import java.util.List;
import java.util.Map;

import com.alibaba.NetCTOSS.beans.logBean.LoginExitBean;

public interface LoginExitMapper {
	
	/**
	 * 查询所有登录日志
	 * @param 
	 * @return
	 */
	public List<LoginExitBean> findAll();
	
	/**
	 * 根据参数查询登录日志
	 * @param params
	 * @return
	 */
	public List<LoginExitBean> findLoginExitsByParams(Map params);
	
	/**
	 * 保存登录日志
	 * @param log
	 * @return
	 */
	public void saveLoginExitBean(LoginExitBean log);
}
