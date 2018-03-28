package com.alibaba.NetCTOSS.admmag.dao_demand;

import java.util.Set;

/**
 * 角色的查询接口
 * @author Administrator
 *
 */
public interface IRoleDemandDao {
	
	
	/**
	 * 通过角色名查询权限信息
	 * @param roleName
	 * @return
	 */
	public Set<String> getPermissions(String roleName);
	
	
	
}
