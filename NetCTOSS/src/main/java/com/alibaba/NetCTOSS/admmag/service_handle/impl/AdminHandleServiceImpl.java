package com.alibaba.NetCTOSS.admmag.service_handle.impl;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import com.alibaba.NetCTOSS.admmag.dao_handle.IAdminHandleDao;
import com.alibaba.NetCTOSS.admmag.service_handle.IAdminHandleService;
import com.alibaba.NetCTOSS.beans.admAndRoleBean.AdministratorBean;
import com.alibaba.NetCTOSS.util.MyLog;

@Service
public class AdminHandleServiceImpl implements IAdminHandleService {

	@Resource
	private IAdminHandleDao iAdminHandleDao;
	@MyLog(place="管理员模块",action="添加")
	@Override
	public void saveAdministratorBean(AdministratorBean administratorBean) {
		// TODO Auto-generated method stub
		iAdminHandleDao.save(administratorBean);
	}
	@MyLog(place="管理员模块",action="修改")
	@Override
	public void updateAdministratorBean(AdministratorBean administratorBean) {
		// TODO Auto-generated method stub
		iAdminHandleDao.saveAndFlush(administratorBean);
	}
	@MyLog(place="管理员模块",action="删除")
	@Override
	public void deleteAdministratorBean(AdministratorBean administratorBean) {
		// TODO Auto-generated method stub
		
	
		iAdminHandleDao.saveAndFlush(administratorBean);
	}

}
