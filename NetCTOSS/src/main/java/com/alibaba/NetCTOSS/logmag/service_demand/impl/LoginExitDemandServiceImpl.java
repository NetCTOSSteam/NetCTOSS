package com.alibaba.NetCTOSS.logmag.service_demand.impl;

import java.util.List;
import java.util.Map;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import com.alibaba.NetCTOSS.beans.logBean.LoginExitBean;
import com.alibaba.NetCTOSS.logmag.dao_demand.ILoginExitDemandDao;
import com.alibaba.NetCTOSS.logmag.dao_demand.impl.LoginExitDemandDaoImpl;
import com.alibaba.NetCTOSS.logmag.service_demand.ILoginExitDemandService;

@Service
public class LoginExitDemandServiceImpl implements ILoginExitDemandService {
	
	@Resource
	ILoginExitDemandDao dao=new LoginExitDemandDaoImpl();

	@Override
	public List<LoginExitBean> findAll() {
		// TODO Auto-generated method stub
		return dao.findAll();
	}

	@Override
	public List<LoginExitBean> findLoginExitsByParams(Map params) {
		// TODO Auto-generated method stub
		return dao.findLoginExitsByParams(params);
	}

}
