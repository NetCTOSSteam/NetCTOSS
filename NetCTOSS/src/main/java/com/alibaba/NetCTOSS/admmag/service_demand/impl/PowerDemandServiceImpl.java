package com.alibaba.NetCTOSS.admmag.service_demand.impl;

import java.util.Set;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import com.alibaba.NetCTOSS.admmag.dao_demand.IPowerDemandDao;
import com.alibaba.NetCTOSS.admmag.service_demand.IPowerDemandService;
import com.alibaba.NetCTOSS.beans.admAndRoleBean.PowerBean;
@Service
public class PowerDemandServiceImpl implements IPowerDemandService {

	@Resource
	private IPowerDemandDao powerDemandDao;
	@Override
	public Set<PowerBean> findAllPowers() {
		// TODO Auto-generated method stub
		return powerDemandDao.findAllPowers();
	}


}
