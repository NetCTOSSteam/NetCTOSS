package com.alibaba.NetCTOSS.billmag.service_handle.impl;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import com.alibaba.NetCTOSS.beans.billBean.AccountYearBillBean;
import com.alibaba.NetCTOSS.billmag.dao_handle.IAccYearHandleDao;
import com.alibaba.NetCTOSS.billmag.service_handle.IAccYearHandleService;
import com.alibaba.NetCTOSS.util.MyLog;

@Service
public class AccYearHandleServiceImpl implements IAccYearHandleService {

	@Resource
	private IAccYearHandleDao iAccYearHandleDao;
	@Override
	@MyLog(action=1,place="saveAccountYearBean")
	public void saveAccountYearBean(AccountYearBillBean bean) {
		// TODO Auto-generated method stub
		iAccYearHandleDao.save(bean);
	}

	@Override
	@MyLog(action=3,place="updateAccountYearBean")
	public void updateAccountYearBean(AccountYearBillBean bean) {
		// TODO Auto-generated method stub
		iAccYearHandleDao.saveAndFlush(bean);
	}

}
