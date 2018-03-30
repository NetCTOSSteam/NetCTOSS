package com.alibaba.NetCTOSS.admmag.service_handle.impl;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import com.alibaba.NetCTOSS.admmag.dao_handle.IAdminHandleDao;
import com.alibaba.NetCTOSS.admmag.service_handle.IAdminHandleService;
import com.alibaba.NetCTOSS.beans.admAndRoleBean.AdministratorBean;

@Service
public class AdminHandleServiceImpl implements IAdminHandleService {

	@Resource
	private IAdminHandleDao iAdminHandleDao;
	@Override
	public void saveAdministratorBean(AdministratorBean administratorBean) {
		// TODO Auto-generated method stub
		iAdminHandleDao.save(administratorBean);
	}

	@Override
	public void updateAdministratorBean(AdministratorBean administratorBean) {
		// TODO Auto-generated method stub
		iAdminHandleDao.saveAndFlush(administratorBean);
	}

	@Override
	public void deleteAdministratorBean(AdministratorBean administratorBean) {
		// TODO Auto-generated method stub
		
	
		iAdminHandleDao.saveAndFlush(administratorBean);
	}

}
