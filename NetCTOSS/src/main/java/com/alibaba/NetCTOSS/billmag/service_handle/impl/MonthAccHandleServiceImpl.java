package com.alibaba.NetCTOSS.billmag.service_handle.impl;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import com.alibaba.NetCTOSS.beans.billBean.MonthAndAccountBean;
import com.alibaba.NetCTOSS.billmag.dao_handle.IMonthAccHandleDao;
import com.alibaba.NetCTOSS.billmag.service_handle.IMonthAccHandleService;

@Service
public class MonthAccHandleServiceImpl implements IMonthAccHandleService {

	@Resource
	private IMonthAccHandleDao iMonthAccHandleDao;
	@Override
	public void saveMonthAndAccountBean(MonthAndAccountBean bean) {
		// TODO Auto-generated method stub
		iMonthAccHandleDao.save(bean);
	}

	@Override
	public void updateMonthAndAccountBean(MonthAndAccountBean bean) {
		// TODO Auto-generated method stub
		iMonthAccHandleDao.saveAndFlush(bean);
	}

}
