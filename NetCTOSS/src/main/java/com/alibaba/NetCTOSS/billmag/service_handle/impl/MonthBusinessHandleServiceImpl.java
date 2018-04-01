package com.alibaba.NetCTOSS.billmag.service_handle.impl;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import com.alibaba.NetCTOSS.beans.billBean.MonthAndBusinessBean;
import com.alibaba.NetCTOSS.billmag.dao_handle.IMonthBusinessHandleDao;
import com.alibaba.NetCTOSS.billmag.service_handle.IMonthBusinessHandleService;

@Service
public class MonthBusinessHandleServiceImpl implements IMonthBusinessHandleService {

	@Resource
	private IMonthBusinessHandleDao iMonthBusinessHandleDao;
	@Override
	public void saveMonthAndBusinessBean(MonthAndBusinessBean bean) {
		// TODO Auto-generated method stub
		iMonthBusinessHandleDao.save(bean);
	}

	@Override
	public void updateMonthAndBusinessBean(MonthAndBusinessBean bean) {
		// TODO Auto-generated method stub
		iMonthBusinessHandleDao.saveAndFlush(bean);
	}

}
