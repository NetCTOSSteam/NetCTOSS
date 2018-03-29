package com.alibaba.NetCTOSS.logmag.dao_demand;

import java.util.List;
import java.util.Map;

import com.alibaba.NetCTOSS.beans.logBean.LoginExitBean;

/**
 * 登录日志 查询
 * @author Administrator
 *
 */
public interface ILoginExitDemandDao {
	
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
	
	
	
}
