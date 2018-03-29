package com.alibaba.NetCTOSS.admmag.service_demand.impl;

import java.util.Map;
import java.util.Set;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import com.alibaba.NetCTOSS.admmag.dao_demand.IAdminDemandDao;
import com.alibaba.NetCTOSS.admmag.dao_demand.IRoleDemandDao;
import com.alibaba.NetCTOSS.admmag.service_demand.IRoleDemandService;
import com.alibaba.NetCTOSS.beans.admAndRoleBean.RoleBean;

@Service
public class RoleDemandServiceImpl implements IRoleDemandService {

	@Resource
	private IRoleDemandDao roleDemandDaoImpl;
	
	@Resource
	private IAdminDemandDao adminDemandDaoImpl;

	/**
	 * 通过角色名查询权限信息
	 * @param roleName
	 * @return
	 */
	@Override
	public Set<String> getPermissions(String roleName) {
		// TODO Auto-generated method stub
		return roleDemandDaoImpl.getPermissions(roleName);
	}

	@Override
	public Set<RoleBean> findAllRoles() {
		// TODO Auto-generated method stub
		return roleDemandDaoImpl.findAllRoles();
	}

	@Override
	public Set<RoleBean> findRolesByCondition(Map<String, String> param) {
		// TODO Auto-generated method stub
		return roleDemandDaoImpl.findRolesByCondition(param);
	}
	
}
