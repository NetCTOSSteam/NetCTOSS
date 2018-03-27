package com.alibaba.NetCTOSS.usermag.service_handle.impl;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import com.alibaba.NetCTOSS.beans.userAndBusBean.BusinessBean;
import com.alibaba.NetCTOSS.usermag.dao_handle.IBusinessHandleDao;
import com.alibaba.NetCTOSS.usermag.service_handle.IBusinessHandleService;
import com.alibaba.NetCTOSS.util.MyLog;
@Service
public class BusinessHandleServiceImpl implements IBusinessHandleService {

	@Resource
	private IBusinessHandleDao iBusinessHandleDao;
	
	@Override
	@MyLog(action=1,place="saveBusinessBean")
	public void saveBusinessBean(BusinessBean bean) {
		// TODO Auto-generated method stub
		iBusinessHandleDao.save(bean);
	}

	@Override
	@MyLog(action=3,place="updateBusinessBean")
	public void updateBusinessBean(BusinessBean bean) {
		// TODO Auto-generated method stub
		iBusinessHandleDao.saveAndFlush(bean);
	}

	@Override
	@MyLog(action=2,place="deleteBusinessBean")
	public void deleteBusinessBean(BusinessBean bean) {
		// TODO Auto-generated method stub
		iBusinessHandleDao.saveAndFlush(bean);
	}

}
