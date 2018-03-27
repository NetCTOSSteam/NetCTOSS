package com.alibaba.NetCTOSS.billmag.service_handle.impl;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import com.alibaba.NetCTOSS.beans.billBean.AccountMonthBean;
import com.alibaba.NetCTOSS.billmag.dao_handle.IAccMonthHandleDao;
import com.alibaba.NetCTOSS.billmag.service_handle.IAccMonthHandleService;

@Service
public class AccMonthHandleServiceImpl implements IAccMonthHandleService {

	@Resource
	private IAccMonthHandleDao iAccMonthHandleDao;
	@Override
	public void saveAccountMonthBean(AccountMonthBean bean) {
		// TODO Auto-generated method stub
		iAccMonthHandleDao.save(bean);
	}

	@Override
	public void updateAccountMonthBean(AccountMonthBean bean) {
		// TODO Auto-generated method stub
		iAccMonthHandleDao.saveAndFlush(bean);
	}

}
