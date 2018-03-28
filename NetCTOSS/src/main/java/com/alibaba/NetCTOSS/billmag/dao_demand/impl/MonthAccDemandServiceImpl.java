package com.alibaba.NetCTOSS.billmag.dao_demand.impl;

import java.util.List;

import javax.annotation.Resource;

import com.alibaba.NetCTOSS.beans.billBean.MonthAndAccountBean;
import com.alibaba.NetCTOSS.billmag.mapper_demand.MonthAccMapper;
import com.alibaba.NetCTOSS.billmag.service_demand.IMonthAccDemandService;

public class MonthAccDemandServiceImpl implements IMonthAccDemandService {

	@Resource
	private MonthAccMapper monthAccMapper;
	@Override
	public List<MonthAndAccountBean> findLikeMonthAndAccountBean(MonthAndAccountBean bean) {
		// TODO Auto-generated method stub
		return monthAccMapper.findLikeMonthAndAccountBean(bean);
	}

	@Override
	public MonthAndAccountBean findByMonthAndAccountBean(MonthAndAccountBean bean) {
		// TODO Auto-generated method stub
		return monthAccMapper.findByMonthAndAccountBean(bean);
	}

}
