package com.alibaba.NetCTOSS.logmag.dao_demand.impl;

import java.util.List;
import java.util.Map;

import javax.annotation.Resource;

import org.springframework.stereotype.Repository;

import com.alibaba.NetCTOSS.beans.logBean.LoginExitBean;
import com.alibaba.NetCTOSS.logmag.dao_demand.ILoginExitDemandDao;
import com.alibaba.NetCTOSS.logmag.mapper_demand.LoginExitMapper;

@Repository
public class LoginExitDemandDaoImpl implements ILoginExitDemandDao {

	@Resource
	private LoginExitMapper le;
	
	@Override
	public List<LoginExitBean> findAll() {
		// TODO Auto-generated method stub
		return le.findAll();
	}

	@Override
	public List<LoginExitBean> findLoginExitsByParams(Map params) {
		// TODO Auto-generated method stub
		return le.findLoginExitsByParams(params);
	}

}
