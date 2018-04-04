package com.alibaba.NetCTOSS.billmag.service_handle.impl;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import com.alibaba.NetCTOSS.beans.billBean.MonthAndBusinessBean;
import com.alibaba.NetCTOSS.billmag.dao_handle.IMonthBusinessHandleDao;
import com.alibaba.NetCTOSS.billmag.service_handle.IMonthBusinessHandleService;
import com.alibaba.NetCTOSS.util.MyLog;
@Service
public class MonthBusinessHandleServiceImpl implements IMonthBusinessHandleService {

	@Resource
	private IMonthBusinessHandleDao iMonthBusinessHandleDao;
	@Override
	@MyLog(place="账单模块",action="添加月账单")
	public void saveMonthAndBusinessBean(MonthAndBusinessBean bean) {
		// TODO Auto-generated method stub
		iMonthBusinessHandleDao.save(bean);
	}

	@Override
	@MyLog(place="账单模块",action="更新月账单")
	public void updateMonthAndBusinessBean(MonthAndBusinessBean bean) {
		// TODO Auto-generated method stub
		iMonthBusinessHandleDao.saveAndFlush(bean);
	}

}
