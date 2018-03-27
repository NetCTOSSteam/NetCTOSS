package com.alibaba.NetCTOSS.billmag.service_demand.impl;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import com.alibaba.NetCTOSS.beans.billBean.AccountYearBillBean;
import com.alibaba.NetCTOSS.billmag.dao_demand.IAccYearDemandDao;
import com.alibaba.NetCTOSS.billmag.service_demand.IAccYearDemandService;
@Service
public class AccYearDemandServiceImpl implements IAccYearDemandService {

	@Resource
	private IAccYearDemandDao iAccYearDemandDao; 
	

	@Override
	public List<AccountYearBillBean> findAccountYearByBean(AccountYearBillBean bean) {
		// TODO Auto-generated method stub
		return iAccYearDemandDao.findAccountDayByBean(bean);
	}

}
