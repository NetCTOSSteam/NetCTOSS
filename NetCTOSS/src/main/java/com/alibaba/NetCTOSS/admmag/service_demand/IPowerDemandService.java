package com.alibaba.NetCTOSS.admmag.service_demand;

import java.util.Set;

import com.alibaba.NetCTOSS.beans.admAndRoleBean.PowerBean;

/**
 * 权限的查询接口
 * @author Administrator
 *
 */
public interface IPowerDemandService {
	
	/**
	 * 通过角色名查找对应的所有权限
	 * @return
	 */
	public Set<PowerBean> findPowersByRoleName(String roleName);
	
	
	
	
}
