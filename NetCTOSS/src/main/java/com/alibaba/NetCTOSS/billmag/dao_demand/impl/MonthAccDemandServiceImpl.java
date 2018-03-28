package com.alibaba.NetCTOSS.billmag.dao_demand.impl;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Repository;

import com.alibaba.NetCTOSS.beans.billBean.MonthAndAccountBean;
import com.alibaba.NetCTOSS.billmag.mapper_demand.MonthAccMapper;
import com.alibaba.NetCTOSS.billmag.service_demand.IMonthAccDemandService;


@Repository
public class MonthAccDemandServiceImpl implements IMonthAccDemandService {

	@Resource
	private MonthAccMapper monthAccMapper;
	@Override
	public List<MonthAndAccountBean> findLikeMonthAndAccountBean(MonthAndAccountBean bean) {
		// TODO Auto-generated method stub
		return monthAccMapper.findLikeMonthAndAccountBean(bean);
	}
	@Override
	public List<Integer> getYear() {
		// TODO Auto-generated method stub
		return monthAccMapper.getYear();
	}
	@Override
	public List<Integer> getMonth() {
		// TODO Auto-generated method stub
		return monthAccMapper.getMonth();
	}


}
