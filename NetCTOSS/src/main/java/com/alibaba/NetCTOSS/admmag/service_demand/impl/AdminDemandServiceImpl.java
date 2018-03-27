package com.alibaba.NetCTOSS.admmag.service_demand.impl;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import com.alibaba.NetCTOSS.admmag.dao_demand.IAdminDemandDao;
import com.alibaba.NetCTOSS.admmag.service_demand.IAdminDemandService;
import com.alibaba.NetCTOSS.beans.admAndRoleBean.AdministratorBean;

@Service
public class AdminDemandServiceImpl implements IAdminDemandService {

	@Resource
	private IAdminDemandDao adminDemandDaoImpl;
	/**
	 * 通过管理员的登录名获取管理员对象
	 */
	@Override
	public AdministratorBean findByAdminLoginName(String adminLoginName) {
		
		return null;
	}
	@Override
	public List<AdministratorBean> findAllAdministratorBeansByParam(AdministratorBean administratorBean) {
		// TODO Auto-generated method stub
		return adminDemandDaoImpl.findAllAdministratorBeansByParam(administratorBean);
	}

}
