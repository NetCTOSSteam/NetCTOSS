package com.alibaba.NetCTOSS.usermag.service_demand.impl;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import com.alibaba.NetCTOSS.beans.userAndBusBean.MealBean;
import com.alibaba.NetCTOSS.usermag.dao_demand.IMealDemandDao;
import com.alibaba.NetCTOSS.usermag.service_demand.IMealDemandService;

@Service
public class MealDemandServiceImpl implements IMealDemandService {

	@Resource
	private IMealDemandDao mealDemandDaoImpl;
	
 @Override
	public List<MealBean> findAllMealBean() {
		// TODO Auto-generated method stub
		return mealDemandDaoImpl.findAllMealBean();
	}

	@Override
	public MealBean findByMealBeanId(int id) {
		// TODO Auto-generated method stub
		return mealDemandDaoImpl.findByMealBeanId(id);
	}

}
