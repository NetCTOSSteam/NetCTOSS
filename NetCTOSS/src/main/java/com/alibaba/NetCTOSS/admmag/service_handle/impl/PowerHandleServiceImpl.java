package com.alibaba.NetCTOSS.admmag.service_handle.impl;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import com.alibaba.NetCTOSS.admmag.dao_handle.IPowerHandleDao;
import com.alibaba.NetCTOSS.admmag.service_handle.IPowerHandleService;
import com.alibaba.NetCTOSS.beans.admAndRoleBean.PowerBean;
import com.alibaba.NetCTOSS.util.MyLog;
@Service
public class PowerHandleServiceImpl implements IPowerHandleService {

	@Resource
	private IPowerHandleDao powerHandleDao;
	@MyLog(place="权限模块",action="添加")
	@Override
	public void savePowerBean(PowerBean power) {
		// TODO Auto-generated method stub
		powerHandleDao.save(power);
	}
	@MyLog(place="权限模块",action="修改")
	@Override
	public void updatePowerBean(PowerBean power) {
		// TODO Auto-generated method stub
		powerHandleDao.saveAndFlush(power);
	}
	@MyLog(place="权限模块",action="删除")
	@Override
	public void deletePowerBean(PowerBean power) {
		// TODO Auto-generated method stub
		powerHandleDao.delete(power);
	}

	@Override
	public PowerBean findPowerBeanByPowerName(String powerName) {
		// TODO Auto-generated method stub
		return powerHandleDao.findPowerBeanByPowerName(powerName);
	}

}
