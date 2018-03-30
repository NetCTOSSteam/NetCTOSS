package com.alibaba.NetCTOSS.logmag.service_demand;

import java.util.List;
import java.util.Map;
import java.util.Set;

import com.alibaba.NetCTOSS.beans.admAndRoleBean.PowerBean;
import com.alibaba.NetCTOSS.beans.logBean.DoLogBean;

/**
 * 操作日志 查询
 * @author Administrator
 *
 */
public interface IDoLogDemandService {
	
	/**
	 * 查询所有日志
	 * @param 
	 * @return
	 */
	public Set<DoLogBean> findAll();
	
	/**
	 * 根据参数查询操作日志
	 * @param params
	 * @return
	 */
	public List<DoLogBean> findDoLogsByParams(Map params);
	
	
	
}
