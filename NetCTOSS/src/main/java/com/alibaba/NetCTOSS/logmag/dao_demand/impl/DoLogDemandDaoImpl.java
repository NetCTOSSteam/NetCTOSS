package com.alibaba.NetCTOSS.logmag.dao_demand.impl;

import java.util.List;
import java.util.Map;

import javax.annotation.Resource;

import org.springframework.stereotype.Repository;

import com.alibaba.NetCTOSS.beans.logBean.DoLogBean;
import com.alibaba.NetCTOSS.logmag.dao_demand.IDoLogDemandDao;
import com.alibaba.NetCTOSS.logmag.mapper_demand.DoLogMapper;

@Repository
public class DoLogDemandDaoImpl implements IDoLogDemandDao{
	@Resource
	private DoLogMapper dg;

	@Override
	public List<DoLogBean> findAll() {
		// TODO Auto-generated method stub
		return dg.findAll();
	}

	@Override
	public List<DoLogBean> findDoLogsByParams(Map params) {
		// TODO Auto-generated method stub
		return dg.findDoLogsByParams(params);
	}	

}
