package com.alibaba.NetCTOSS.admmag.service_handle;

import com.alibaba.NetCTOSS.beans.admAndRoleBean.RoleBean;

/**
 * 角色的操作接口
 * @author Administrator
 *
 */
public interface IRoleHandleService {
	
	/**
	 * 添加角色信息
	 * @param role
	 */
	public void saveRole(RoleBean role);
	
	/**
	 * 修改角色信息
	 * @param role
	 */
	public void updateRole(RoleBean role);
	
	/**
	 * 删除角色信息
	 * @param role
	 */
	public void deleteRole(RoleBean role);
	
	/**
	 * 通过id查找role对象
	 * @param id
	 * @return
	 */
	public RoleBean findById(int id);
}
