package com.alibaba.NetCTOSS.admmag.dao_demand.impl;

import java.util.Set;

import javax.annotation.Resource;

import org.springframework.stereotype.Repository;

import com.alibaba.NetCTOSS.admmag.dao_demand.IPowerDemandDao;
import com.alibaba.NetCTOSS.admmag.mapper_demand.PowerMapper;
import com.alibaba.NetCTOSS.beans.admAndRoleBean.PowerBean;
@Repository
public class PowerDemandDaoImpl implements IPowerDemandDao {

	@Resource
	private PowerMapper powerMapper;
	@Override
	public Set<PowerBean> findAllPowers() {
		// TODO Auto-generated method stub
		return powerMapper.findAllPowers();
	}

	

}
