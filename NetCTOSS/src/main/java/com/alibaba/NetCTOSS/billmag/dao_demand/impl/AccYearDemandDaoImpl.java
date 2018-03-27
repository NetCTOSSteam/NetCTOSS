package com.alibaba.NetCTOSS.billmag.dao_demand.impl;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Repository;

import com.alibaba.NetCTOSS.beans.billBean.AccountYearBillBean;
import com.alibaba.NetCTOSS.billmag.dao_demand.IAccYearDemandDao;
import com.alibaba.NetCTOSS.billmag.mapper_demand.AccYearMapper;
@Repository
public class AccYearDemandDaoImpl implements IAccYearDemandDao {

	@Resource
	private AccYearMapper accYearMapper;
	@Override
	public List<AccountYearBillBean> findAccountDayByBean(AccountYearBillBean bean) {
		// TODO Auto-generated method stub
		return accYearMapper.findAccountDayByBean(bean);
	}

}
