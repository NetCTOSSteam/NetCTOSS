package com.alibaba.NetCTOSS.admmag.mapper_demand;

import java.util.Set;

import org.springframework.data.repository.query.Param;

public interface RoleMapper {
	/**
	 * 通过角色名查询权限信息
	 * @param roleName
	 * @return
	 */
	public Set<String> getPermissions(@Param("roleName")String roleName);
}
