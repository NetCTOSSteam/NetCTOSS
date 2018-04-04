package com.alibaba.NetCTOSS.admmag.service_handle.impl;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import com.alibaba.NetCTOSS.admmag.dao_handle.IRoleHandleDao;
import com.alibaba.NetCTOSS.admmag.service_handle.IRoleHandleService;
import com.alibaba.NetCTOSS.beans.admAndRoleBean.RoleBean;
import com.alibaba.NetCTOSS.util.MyLog;
@Service
public class RoleHandleServiceImpl implements IRoleHandleService {

	@Resource
	private IRoleHandleDao  roleHandleDaoImpl; 
	
	@MyLog(place="角色模块",action="添加")
	@Override
	public void saveRole(RoleBean role) {
		// TODO Auto-generated method stub
		roleHandleDaoImpl.save(role);
	}

	@MyLog(place="角色模块",action="修改")
	@Override
	public void updateRole(RoleBean role) {
		// TODO Auto-generated method stub
		roleHandleDaoImpl.saveAndFlush(role);
	}

	@MyLog(place="角色模块",action="删除")
	@Override
	public void deleteRole(RoleBean role) {
		// TODO Auto-generated method stub
		roleHandleDaoImpl.saveAndFlush(role);
	}

	@Override
	public RoleBean findById(int id) {
		// TODO Auto-generated method stub
		return roleHandleDaoImpl.findOne(id);
	}

}
