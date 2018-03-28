package com.alibaba.NetCTOSS.admmag.service_demand.impl;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import com.alibaba.NetCTOSS.admmag.dao_demand.IAdminDemandDao;
import com.alibaba.NetCTOSS.admmag.service_demand.IAdminDemandService;
import com.alibaba.NetCTOSS.beans.admAndRoleBean.AdministratorBean;
import com.alibaba.NetCTOSS.beans.admAndRoleBean.RoleBean;

@Service
public class AdminDemandServiceImpl implements IAdminDemandService {

	@Resource
	private IAdminDemandDao adminDemandDaoImpl;
	/**
	 * 通过管理员的登录名获取管理员对象
	 */
	@Override
	public AdministratorBean findAdminByAdminLoginName(String adminLoginName) {
		// TODO Auto-generated method stub
		return adminDemandDaoImpl.findAdminByAdminLoginName(adminLoginName);
	}
	
	/**
	 * 通过管理员登录名查找角色信息
	 * @param adminLoginName
	 * @return
	 */
	@Override
	public RoleBean getRole(String adminLoginName) {
		// TODO Auto-generated method stub
		return adminDemandDaoImpl.getRole(adminLoginName);
	}
	
	@Override
	public List<AdministratorBean> findAllAdministratorBeansByParam(AdministratorBean administratorBean) {
		// TODO Auto-generated method stub
		return adminDemandDaoImpl.findAllAdministratorBeansByParam(administratorBean);
	}
	
	

}
