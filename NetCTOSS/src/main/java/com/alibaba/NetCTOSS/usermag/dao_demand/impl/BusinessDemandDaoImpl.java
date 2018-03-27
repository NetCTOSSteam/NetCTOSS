package com.alibaba.NetCTOSS.usermag.dao_demand.impl;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Repository;

import com.alibaba.NetCTOSS.beans.userAndBusBean.BusinessBean;
import com.alibaba.NetCTOSS.usermag.dao_demand.IBusinessDemandDao;
import com.alibaba.NetCTOSS.usermag.mapper_demand.BusinessMapper;
@Repository
public class BusinessDemandDaoImpl implements IBusinessDemandDao {
	
	@Resource
	private BusinessMapper businessMapper;
	@Override
	public List<BusinessBean> findLikeByBean(BusinessBean bean) {
		// TODO Auto-generated method stub
		return businessMapper.findLikeByBean(bean);
	}

	@Override
	public BusinessBean findByBean(BusinessBean bean) {
		// TODO Auto-generated method stub
		return businessMapper.findByBean(bean);
	}

	@Override
	public List<BusinessBean> findByUserId(int id) {
		// TODO Auto-generated method stub
		return businessMapper.findByUserId(id);
	}

}
