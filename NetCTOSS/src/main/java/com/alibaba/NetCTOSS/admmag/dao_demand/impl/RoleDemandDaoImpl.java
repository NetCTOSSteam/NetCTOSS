package com.alibaba.NetCTOSS.admmag.dao_demand.impl;

import java.util.HashSet;
import java.util.Set;

import javax.annotation.Resource;

import org.springframework.stereotype.Repository;

import com.alibaba.NetCTOSS.admmag.dao_demand.IRoleDemandDao;
import com.alibaba.NetCTOSS.admmag.mapper_demand.RoleMapper;
import com.alibaba.NetCTOSS.beans.admAndRoleBean.PowerBean;
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
}
