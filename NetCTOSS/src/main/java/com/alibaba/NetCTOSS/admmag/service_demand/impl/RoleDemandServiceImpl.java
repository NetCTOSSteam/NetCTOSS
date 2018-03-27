package com.alibaba.NetCTOSS.admmag.service_demand.impl;

import java.util.Set;

import org.springframework.stereotype.Service;

import com.alibaba.NetCTOSS.admmag.service_demand.IRoleDemandService;
import com.alibaba.NetCTOSS.beans.admAndRoleBean.RoleBean;

@Service
public class RoleDemandServiceImpl implements IRoleDemandService {

	/**
	 * 通过管理员登录名获取对应的角色
	 * @param adminLoginName
	 * @return
	 */
	@Override
	public RoleBean findRoleByAdminLoginName(String adminLoginName) {
		// TODO Auto-generated method stub
		return null;
	}

	/**
	 * 通过角色名查询权限信息
	 * @param roleName
	 * @return
	 */
	@Override
	public Set<String> getPermissions(String roleName) {
		// TODO Auto-generated method stub
		return null;
	}
	
}
