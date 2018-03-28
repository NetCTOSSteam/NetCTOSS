package com.alibaba.NetCTOSS.billmag.service_demand.impl;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import com.alibaba.NetCTOSS.beans.billBean.MonthAndAccountBean;
import com.alibaba.NetCTOSS.billmag.dao_demand.IMonthAccDemandDao;
import com.alibaba.NetCTOSS.billmag.service_demand.IMonthAccDemandService;

@Service
public class MonthAccDemandServiceImpl implements IMonthAccDemandService {

	@Resource
	private IMonthAccDemandDao iMonthAccDemandDao;
	@Override
	public List<MonthAndAccountBean> findLikeMonthAndAccountBean(MonthAndAccountBean bean) {
		// TODO Auto-generated method stub
		return iMonthAccDemandDao.findLikeMonthAndAccountBean(bean);
	}
	@Override
	public List<Integer> getYear() {
		// TODO Auto-generated method stub
		return iMonthAccDemandDao.getYear();
	}
	@Override
	public List<Integer> getMonth() {
		// TODO Auto-generated method stub
		return iMonthAccDemandDao.getMonth();
	}


}
