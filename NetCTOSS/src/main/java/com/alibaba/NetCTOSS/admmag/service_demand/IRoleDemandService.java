package com.alibaba.NetCTOSS.admmag.service_demand;

import java.util.Set;

import com.alibaba.NetCTOSS.beans.admAndRoleBean.RoleBean;

/**
 * 角色的查询接口
 * @author Administrator
 *
 */
public interface IRoleDemandService {
	
	/**
	 * 通过角色名查询权限信息
	 * @param roleName
	 * @return
	 */
	public Set<String> getPermissions(String roleName);
	
	
}
