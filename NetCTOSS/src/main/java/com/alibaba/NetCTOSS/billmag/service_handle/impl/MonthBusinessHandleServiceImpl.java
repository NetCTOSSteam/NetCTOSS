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
	@MyLog(action="1",place="saveMonthAndBusinessBean")
	public void saveMonthAndBusinessBean(MonthAndBusinessBean bean) {
		// TODO Auto-generated method stub
		iMonthBusinessHandleDao.save(bean);
	}

	@Override
	@MyLog(action="3",place="updateMonthAndBusinessBean")
	public void updateMonthAndBusinessBean(MonthAndBusinessBean bean) {
		// TODO Auto-generated method stub
		iMonthBusinessHandleDao.saveAndFlush(bean);
	}

}
