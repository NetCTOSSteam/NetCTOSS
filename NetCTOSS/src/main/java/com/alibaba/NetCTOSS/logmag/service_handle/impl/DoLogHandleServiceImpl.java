package com.alibaba.NetCTOSS.logmag.service_handle.impl;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import com.alibaba.NetCTOSS.beans.logBean.DoLogBean;
import com.alibaba.NetCTOSS.logmag.dao_handle.IDoLogHandleDao;
import com.alibaba.NetCTOSS.logmag.service_handle.IDoLogHandleService;

@Service
public class DoLogHandleServiceImpl implements IDoLogHandleService {

	@Resource
	private IDoLogHandleDao doLogHandleDao;
	
	@Override
	public void saveDoLogBean(DoLogBean log) {
		// TODO Auto-generated method stub
		doLogHandleDao.save(log);
	}

	

	
}
