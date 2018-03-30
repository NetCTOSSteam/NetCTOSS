package com.alibaba.NetCTOSS.admmag.service_handle.impl;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import com.alibaba.NetCTOSS.admmag.dao_handle.IPowerHandleDao;
import com.alibaba.NetCTOSS.admmag.service_handle.IPowerHandleService;
import com.alibaba.NetCTOSS.beans.admAndRoleBean.PowerBean;
@Service
public class PowerHandleServiceImpl implements IPowerHandleService {

	@Resource
	private IPowerHandleDao powerHandleDao;
	@Override
	public void savePowerBean(PowerBean power) {
		// TODO Auto-generated method stub
		powerHandleDao.save(power);
	}

	@Override
	public void updatePowerBean(PowerBean power) {
		// TODO Auto-generated method stub
		powerHandleDao.saveAndFlush(power);
	}

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
