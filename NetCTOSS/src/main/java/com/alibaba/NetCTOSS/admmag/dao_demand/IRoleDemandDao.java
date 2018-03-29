package com.alibaba.NetCTOSS.admmag.dao_demand;

import java.util.Set;

import com.alibaba.NetCTOSS.beans.admAndRoleBean.RoleBean;

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
	
	/**
	 * 查询所有角色信息
	 * @return
	 */
	public Set<RoleBean> findAllRoles();
	
	/**
	 * 按照条件查询
	 * @param roleName角色的名称
	 * @param rolePermission角色的权限
	 * @return
	 */
	public Set<RoleBean> findRolesByCondition(String roleName,String rolePermission);
	
}
