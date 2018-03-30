package com.alibaba.NetCTOSS.admmag.service_demand;

import java.util.List;
import java.util.Map;

import com.alibaba.NetCTOSS.beans.admAndRoleBean.PowerBean;

/**
 * 权限的查询接口
 * @author Administrator
 *
 */
public interface IPowerDemandService {
	
	
	/**
	 * 查询所有的权限信息
	 * @return
	 */
	public List<PowerBean> findAllPowers();
	
	/**
	 * 根据参数查询权限信息
	 * @param param
	 * @return
	 */
	public List<PowerBean> findPowersByCondition(Map<String, String> param);
}
