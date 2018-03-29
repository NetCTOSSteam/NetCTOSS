package com.alibaba.NetCTOSS.admmag.service_handle.impl;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import com.alibaba.NetCTOSS.admmag.dao_handle.IRoleHandleDao;
import com.alibaba.NetCTOSS.admmag.service_handle.IRoleHandleService;
import com.alibaba.NetCTOSS.beans.admAndRoleBean.RoleBean;
@Service
public class RoleHandleServiceImpl implements IRoleHandleService {

	@Resource
	private IRoleHandleDao  roleHandleDaoImpl; 
	@Override
	public void saveRole(RoleBean role) {
		// TODO Auto-generated method stub
		roleHandleDaoImpl.save(role);
	}

	@Override
	public void updateRole(RoleBean role) {
		// TODO Auto-generated method stub
		roleHandleDaoImpl.saveAndFlush(role);
	}

	@Override
	public void deleteRole(RoleBean role) {
		// TODO Auto-generated method stub
		roleHandleDaoImpl.delete(role);
	}

}
