package com.alibaba.NetCTOSS.usermag.service_demand.impl;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import com.alibaba.NetCTOSS.beans.userAndBusBean.BusinessBean;
import com.alibaba.NetCTOSS.usermag.dao_demand.IBusinessDemandDao;
import com.alibaba.NetCTOSS.usermag.service_demand.IBusinessDemandService;
@Service
public class BusinessDemandServiceImpl implements IBusinessDemandService {

	@Resource
	private IBusinessDemandDao iBusinessDemandDao;
	@Override
	public List<BusinessBean> findLikeByBean(BusinessBean bean) {
		// TODO Auto-generated method stub
		return iBusinessDemandDao.findLikeByBean(bean);
	}

	@Override
	public BusinessBean findByBean(BusinessBean bean) {
		// TODO Auto-generated method stub
		return iBusinessDemandDao.findByBean(bean);
	}

	@Override
	public List<BusinessBean> findByUserId(int id) {
		// TODO Auto-generated method stub
		return iBusinessDemandDao.findByUserId(id);
	}

}
