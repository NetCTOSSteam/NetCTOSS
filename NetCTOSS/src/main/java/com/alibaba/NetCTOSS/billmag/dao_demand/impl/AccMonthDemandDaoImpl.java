package com.alibaba.NetCTOSS.billmag.dao_demand.impl;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Repository;

import com.alibaba.NetCTOSS.beans.billBean.AccountMonthBean;
import com.alibaba.NetCTOSS.billmag.dao_demand.IAccMonthDemandDao;
import com.alibaba.NetCTOSS.billmag.mapper_demand.AccMonthMapper;

@Repository
public class AccMonthDemandDaoImpl implements IAccMonthDemandDao {

	@Resource
	private AccMonthMapper accMonthMapper;
	@Override
	public List<AccountMonthBean> findAccountDayByBean(AccountMonthBean bean) {
		// TODO Auto-generated method stub
		return accMonthMapper.findAccountDayByBean(bean);
	}

}
