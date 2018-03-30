package com.alibaba.NetCTOSS.usermag.service_handle.impl;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import com.alibaba.NetCTOSS.beans.userAndBusBean.UserBean;
import com.alibaba.NetCTOSS.usermag.dao_handle.IUserHandleDao;
import com.alibaba.NetCTOSS.usermag.service_handle.IUserHandleService;
import com.alibaba.NetCTOSS.util.MyLog;

@Service
public class UserHandleServiceImpl implements IUserHandleService {

	@Resource
	private IUserHandleDao iUserHandleDao;
	@Override
	@MyLog(action="1",place="saveUserBean")
	public void saveUserBean(UserBean bean) {
		// TODO Auto-generated method stub
		iUserHandleDao.save(bean);
	}

	@Override
	@MyLog(action="3",place="updateUserBean")
	public void updateUserBean(UserBean bean) {
		// TODO Auto-generated method stub
		iUserHandleDao.saveAndFlush(bean);
	}

	@Override
	@MyLog(action="2",place="deleteUserBean")
	public void deleteUserBean(UserBean bean) {
		// TODO Auto-generated method stub
		
	}

}
