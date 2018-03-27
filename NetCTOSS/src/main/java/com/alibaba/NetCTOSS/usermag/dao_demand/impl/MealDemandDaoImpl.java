package com.alibaba.NetCTOSS.usermag.dao_demand.impl;

import java.util.List;

import com.alibaba.NetCTOSS.beans.userAndBusBean.MealBean;
import com.alibaba.NetCTOSS.usermag.dao_demand.IMealDemandDao;

public class MealDemandDaoImpl implements IMealDemandDao {
	/**
	 * 查询所有MealBean，好在页面进行分页
	 * @return mealBean 集合
	 */
	@Override
	public List<MealBean> findAllMealBean() {
		// TODO Auto-generated method stub
		return null;
	}
	/**
	 * 根据ID查询MealBean 
	 * 查询出根据MealBean的资费状态判断能否进行操作
	 * @param id mealBean ID
	 * @return MealBean
	 */
	@Override
	public MealBean findByMealBeanId(int id) {
		// TODO Auto-generated method stub
		return null;
	}

}
