package com.alibaba.NetCTOSS.admmag.mapper_demand;

import java.util.Set;

import org.springframework.data.repository.query.Param;

import com.alibaba.NetCTOSS.beans.admAndRoleBean.PowerBean;

public interface RoleMapper {
	/**
	 * 通过角色名查询权限信息
	 * @param roleName
	 * @return
	 */
	public Set<PowerBean> getPermissions(@Param("roleName")String roleName);
}
