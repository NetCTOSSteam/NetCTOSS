package com.alibaba.NetCTOSS.billmag.service_demand.impl;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import com.alibaba.NetCTOSS.beans.billBean.AccountDayBean;
import com.alibaba.NetCTOSS.billmag.dao_demand.IAccDayDemandDao;
import com.alibaba.NetCTOSS.billmag.service_demand.IAccDayDemandService;

@Service
public class AccDayDemandServiceImpl implements IAccDayDemandService {

	@Resource
	private IAccDayDemandDao iAccDayDemandDao; 
	@Override
	public List<AccountDayBean> findAccountDayByBean(AccountDayBean bean) {
		// TODO Auto-generated method stub
		return iAccDayDemandDao.findAccountDayByBean(bean);
	}

}
