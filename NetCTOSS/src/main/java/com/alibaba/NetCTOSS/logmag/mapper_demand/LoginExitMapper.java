package com.alibaba.NetCTOSS.logmag.mapper_demand;

import java.util.List;
import java.util.Map;

import org.apache.ibatis.annotations.Param;

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
	public List<LoginExitBean> findLoginExitsByParams(@Param("params") Map params);
	
	
}
