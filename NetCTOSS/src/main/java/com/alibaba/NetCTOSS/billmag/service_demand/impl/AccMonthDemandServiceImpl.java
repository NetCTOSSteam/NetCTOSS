package com.alibaba.NetCTOSS.billmag.service_demand.impl;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import com.alibaba.NetCTOSS.beans.billBean.AccountMonthBean;
import com.alibaba.NetCTOSS.billmag.dao_demand.IAccMonthDemandDao;
import com.alibaba.NetCTOSS.billmag.service_demand.IAccMonthDemandService;
@Service
public class AccMonthDemandServiceImpl implements IAccMonthDemandService {

	@Resource
	private IAccMonthDemandDao iAccMonthDemandDao; 

	@Override
	public List<AccountMonthBean> findAccountDayByBean(AccountMonthBean bean) {
		// TODO Auto-generated method stub
		return iAccMonthDemandDao.findAccountDayByBean(bean);
	}

}
