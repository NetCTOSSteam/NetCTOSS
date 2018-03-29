package com.alibaba.NetCTOSS.logmag.service_handle.impl;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import com.alibaba.NetCTOSS.beans.logBean.LoginExitBean;
import com.alibaba.NetCTOSS.logmag.dao_handle.IDoLogHandleDao;
import com.alibaba.NetCTOSS.logmag.dao_handle.ILoginExitHandleDao;
import com.alibaba.NetCTOSS.logmag.service_handle.ILoginExitHandleService;

@Service
public class LoginExitHandleServiceImpl implements ILoginExitHandleService {
	
	@Resource
	private ILoginExitHandleDao loginExitHandleDao;

	@Override
	public void saveLoginExitBean(LoginExitBean log) {
		// TODO Auto-generated method stub
		loginExitHandleDao.save(log);
	}

}
