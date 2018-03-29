package com.alibaba.NetCTOSS.admmag.mapper_demand;

import java.util.List;
import java.util.Map;
import java.util.Set;

import org.springframework.data.repository.query.Param;

import com.alibaba.NetCTOSS.beans.admAndRoleBean.PowerBean;
import com.alibaba.NetCTOSS.beans.admAndRoleBean.RoleBean;

public interface RoleMapper {
	/**
	 * 通过角色名查询权限信息
	 * @param roleName
	 * @return
	 */
	public Set<PowerBean> getPermissions(@Param("roleName")String roleName);
	
	/**
	 * 查询所有角色信息
	 * @return
	 */
	public List<RoleBean> findAllRoles();
	
	/**
	 * 按照条件查询
	 * @param roleName角色的名称
	 * @param rolePermission角色的权限
	 * @return
	 */
	public List<RoleBean> findRolesByCondition(@Param("param")Map<String, String> param);
}
