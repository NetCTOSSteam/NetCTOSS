package com.alibaba.NetCTOSS.billmag.dao_demand.impl;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Repository;

import com.alibaba.NetCTOSS.beans.billBean.MonthAndBusinessBean;
import com.alibaba.NetCTOSS.billmag.dao_demand.IMonthBusinessDemandDao;
import com.alibaba.NetCTOSS.billmag.mapper_demand.MonthBusinessMapper;
@Repository
public class MonthBusinessDemandDaoImpl implements IMonthBusinessDemandDao {

	@Resource
	private MonthBusinessMapper monthBusinessMapper;
	@Override
	public List<MonthAndBusinessBean> findLikeMonthAndBusinessBean(MonthAndBusinessBean bean) {
		// TODO Auto-generated method stub
		return monthBusinessMapper.findLikeMonthAndBusinessBean(bean);
	}

	@Override
	public MonthAndBusinessBean findByMonthAndBusinessBean(MonthAndBusinessBean bean) {
		// TODO Auto-generated method stub
		return monthBusinessMapper.findByMonthAndBusinessBean(bean);
	}

	@Override
	public List<MonthAndBusinessBean> findByServerMothAndBusinessBean(String account_acc) {
		// TODO Auto-generated method stub
		return monthBusinessMapper.findByServerMothAndBusinessBean(account_acc);
	}

	@Override
	public List<MonthAndBusinessBean> findByServerMothAndBusinessBeanTariff(String tariff) {
		// TODO Auto-generated method stub
		return monthBusinessMapper.findByServerMothAndBusinessBeanTariff(tariff);
	}

	@Override
	public List<MonthAndBusinessBean> findByServerMothAndBusinessBeanAllTariff() {
		// TODO Auto-generated method stub
		return monthBusinessMapper.findByServerMothAndBusinessBeanAllTariff();
	}
	
	

}
