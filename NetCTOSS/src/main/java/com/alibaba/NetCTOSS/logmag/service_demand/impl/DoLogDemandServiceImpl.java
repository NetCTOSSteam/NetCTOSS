package com.alibaba.NetCTOSS.logmag.service_demand.impl;

import java.util.List;
import java.util.Map;

import javax.annotation.Resource;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import com.alibaba.NetCTOSS.beans.logBean.DoLogBean;
import com.alibaba.NetCTOSS.logmag.dao_demand.IDoLogDemandDao;
import com.alibaba.NetCTOSS.logmag.dao_demand.impl.DoLogDemandDaoImpl;
import com.alibaba.NetCTOSS.logmag.service_demand.IDoLogDemandService;

@Service
public class DoLogDemandServiceImpl implements IDoLogDemandService {

	@Resource
	IDoLogDemandDao dao=new DoLogDemandDaoImpl();

	@Override
	public List<DoLogBean> findAll() {
		// TODO Auto-generated method stub
		return dao.findAll();
	}

	@Override
	public List<DoLogBean> findDoLogsByParams(Map params) {
		// TODO Auto-generated method stub
		return dao.findDoLogsByParams(params);
	}
	
}
	
