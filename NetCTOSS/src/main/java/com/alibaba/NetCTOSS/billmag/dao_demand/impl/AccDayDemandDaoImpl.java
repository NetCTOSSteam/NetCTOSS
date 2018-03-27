package com.alibaba.NetCTOSS.billmag.dao_demand.impl;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Repository;

import com.alibaba.NetCTOSS.beans.billBean.AccountDayBean;
import com.alibaba.NetCTOSS.billmag.dao_demand.IAccDayDemandDao;
import com.alibaba.NetCTOSS.billmag.mapper_demand.AccDayMapper;

@Repository
public class AccDayDemandDaoImpl implements IAccDayDemandDao {

	@Resource
	private AccDayMapper accDayMapper;
	@Override
	public List<AccountDayBean> findAccountDayByBean(AccountDayBean bean) {
		// TODO Auto-generated method stub
		return accDayMapper.findAccountDayByBean(bean);
	}

}
