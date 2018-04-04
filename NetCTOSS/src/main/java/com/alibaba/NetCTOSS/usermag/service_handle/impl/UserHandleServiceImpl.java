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
	@MyLog(place="账务帐号",action="添加")
	public void saveUserBean(UserBean bean) {
		// TODO Auto-generated method stub
		iUserHandleDao.save(bean);
	}

	@Override
	@MyLog(place="账务帐号",action="修改")
	public void updateUserBean(UserBean bean) {
		// TODO Auto-generated method stub
		iUserHandleDao.saveAndFlush(bean);
	}

	@Override
	@MyLog(place="账务帐号",action="删除")
	public void deleteUserBean(UserBean bean) {
		// TODO Auto-generated method stub
		iUserHandleDao.saveAndFlush(bean);
	}

}
