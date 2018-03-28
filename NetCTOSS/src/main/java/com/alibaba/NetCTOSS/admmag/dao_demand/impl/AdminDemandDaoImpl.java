package com.alibaba.NetCTOSS.admmag.dao_demand.impl;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Repository;

import com.alibaba.NetCTOSS.admmag.dao_demand.IAdminDemandDao;
import com.alibaba.NetCTOSS.admmag.mapper_demand.AdminMapper;
import com.alibaba.NetCTOSS.beans.admAndRoleBean.AdministratorBean;
import com.alibaba.NetCTOSS.beans.admAndRoleBean.RoleBean;

@Repository
public class AdminDemandDaoImpl implements IAdminDemandDao {

	@Resource
	private AdminMapper adminMapper;
	@Override
	public List<AdministratorBean> findAllAdministratorBeansByParam(AdministratorBean administratorBean){
		// TODO Auto-generated method stub
		return adminMapper.findAllAdministratorBeansByParam(administratorBean);
	}
	@Override
	public AdministratorBean findAdminByAdminLoginName(String adminLoginName) {
		// TODO Auto-generated method stub
		return adminMapper.findAdminByAdminLoginName(adminLoginName);
	}
	@Override
	public RoleBean getRole(String adminLoginName) {
		// TODO Auto-generated method stub
		return adminMapper.getRole(adminLoginName);
	}

}
