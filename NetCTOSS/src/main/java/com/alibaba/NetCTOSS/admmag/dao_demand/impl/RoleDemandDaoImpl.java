package com.alibaba.NetCTOSS.admmag.dao_demand.impl;

import java.util.Set;

import javax.annotation.Resource;

import org.springframework.stereotype.Repository;

import com.alibaba.NetCTOSS.admmag.dao_demand.IRoleDemandDao;
import com.alibaba.NetCTOSS.admmag.service_demand.IRoleDemandService;
@Repository
public class RoleDemandDaoImpl implements IRoleDemandDao {

	@Resource
	private IRoleDemandService roleDemandServiceImpl;
	@Override
	public Set<String> getPermissions(String roleName) {
		// TODO Auto-generated method stub
		return roleDemandServiceImpl.getPermissions(roleName);
	}
}
