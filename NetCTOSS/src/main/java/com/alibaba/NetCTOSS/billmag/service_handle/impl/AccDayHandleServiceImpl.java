package com.alibaba.NetCTOSS.billmag.service_handle.impl;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import com.alibaba.NetCTOSS.beans.billBean.AccountDayBean;
import com.alibaba.NetCTOSS.billmag.dao_handle.IAccDayHandleDao;
import com.alibaba.NetCTOSS.billmag.service_handle.IAccDayHandleService;
import com.alibaba.NetCTOSS.util.MyLog;
@Service
public class AccDayHandleServiceImpl implements IAccDayHandleService {

	@Resource
	private IAccDayHandleDao iAccDayHandleDao;
	@Override
	@MyLog(action="1",place="saveAccountDayBean")
	public void saveAccountDayBean(AccountDayBean bean) {
		// TODO Auto-generated method stub
		iAccDayHandleDao.save(bean);
	}

	@Override
	@MyLog(action="3",place="updateAccountDayBean")
	public void updateAccountDayBean(AccountDayBean bean) {
		// TODO Auto-generated method stub
		iAccDayHandleDao.saveAndFlush(bean);
	}

}
