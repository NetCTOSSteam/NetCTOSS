package com.alibaba.NetCTOSS.billmag.dao_demand.impl;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Repository;

import com.alibaba.NetCTOSS.beans.billBean.MonthAndAccountBean;
import com.alibaba.NetCTOSS.billmag.dao_demand.IMonthAccDemandDao;
import com.alibaba.NetCTOSS.billmag.mapper_demand.MonthAccMapper;


@Repository
public class MonthAccDemandDaoImpl implements IMonthAccDemandDao {

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
	@Override
	public MonthAndAccountBean findByMonthAndAccountBean(MonthAndAccountBean maab) {
		// TODO Auto-generated method stub
		return monthAccMapper.findByMonthAndAccountBean(maab);
	}
	@Override
	public List<MonthAndAccountBean> findByYearAndAccount(int year, String account) {
		// TODO Auto-generated method stub
		return monthAccMapper.findByYearAndAccount(year, account);
	}


}
