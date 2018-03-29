package com.alibaba.NetCTOSS.billmag.service_demand.impl;

import java.util.List;

import javax.annotation.Resource;

import com.alibaba.NetCTOSS.beans.billBean.MonthAndBusinessBean;
import com.alibaba.NetCTOSS.billmag.dao_demand.IMonthBusinessDemandDao;
import com.alibaba.NetCTOSS.billmag.service_demand.IMonthBusinessDemandService;

public class MonthBusinessDemandServiceImpl implements IMonthBusinessDemandService {

	@Resource
	private IMonthBusinessDemandDao iMonthBusinessDemandDao;
	@Override
	public List<MonthAndBusinessBean> findLikeMonthAndBusinessBean(MonthAndBusinessBean bean) {
		// TODO Auto-generated method stub
		return iMonthBusinessDemandDao.findLikeMonthAndBusinessBean(bean);
	}

	@Override
	public MonthAndBusinessBean findByMonthAndBusinessBean(MonthAndBusinessBean bean) {
		// TODO Auto-generated method stub
		return iMonthBusinessDemandDao.findByMonthAndBusinessBean(bean);
	}

	@Override
	public List<MonthAndBusinessBean> findByServerMothAndBusinessBean(String account_acc) {
		// TODO Auto-generated method stub
		return null;
	}

	
	
}
