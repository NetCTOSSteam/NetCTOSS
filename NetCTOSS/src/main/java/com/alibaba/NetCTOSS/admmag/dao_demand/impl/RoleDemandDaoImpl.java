package com.alibaba.NetCTOSS.admmag.dao_demand.impl;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;

import javax.annotation.Resource;

import org.springframework.stereotype.Repository;

import com.alibaba.NetCTOSS.admmag.dao_demand.IRoleDemandDao;
import com.alibaba.NetCTOSS.admmag.mapper_demand.RoleMapper;
import com.alibaba.NetCTOSS.beans.admAndRoleBean.PowerBean;
import com.alibaba.NetCTOSS.beans.admAndRoleBean.RoleBean;
@Repository
public class RoleDemandDaoImpl implements IRoleDemandDao {

	@Resource
	private RoleMapper roleMapper;
	@Override
	public Set<String> getPermissions(String roleName) {
		// TODO Auto-generated method stub
		Set<PowerBean> set = roleMapper.getPermissions(roleName);
		Set<String> permissions = new HashSet<>();
		for (PowerBean powerBean : set) {
			permissions.add(powerBean.getPowerName());
		}
		return permissions;
	}
	@Override
	public List<RoleBean> findAllRoles() {
		// TODO Auto-generated method stub
		return roleMapper.findAllRoles();
	}
	@Override
	public List<RoleBean> findRolesByCondition(Map<String, String> param) {
		// TODO Auto-generated method stub
		
		return roleMapper.findRolesByCondition(param);
	}
}
