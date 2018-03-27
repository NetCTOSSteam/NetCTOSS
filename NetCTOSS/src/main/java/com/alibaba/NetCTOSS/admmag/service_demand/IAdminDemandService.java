package com.alibaba.NetCTOSS.admmag.service_demand;

import com.alibaba.NetCTOSS.beans.admAndRoleBean.AdministratorBean;

/**
 * 管理员的查询接口
 * @author Administrator
 *
 */
public interface IAdminDemandService {
	
	/**
	 * 通过管理员的登录名获取管理员对象
	 * @param adminName
	 * @return
	 */
	public AdministratorBean findByAdminLoginName(String adminLoginName);
	
	
	
	
}
