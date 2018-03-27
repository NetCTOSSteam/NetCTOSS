package com.alibaba.NetCTOSS.admmag.service_demand;

import com.alibaba.NetCTOSS.beans.admAndRoleBean.RoleBean;

/**
 * 角色的查询接口
 * @author Administrator
 *
 */
public interface IRoleDemandService {
	
	/**
	 * 通过管理员登录名获取对应的角色
	 * @param adminLoginName
	 * @return
	 */
	public RoleBean findRoleByAdminLoginName(String adminLoginName);
	
	
	
	
}
