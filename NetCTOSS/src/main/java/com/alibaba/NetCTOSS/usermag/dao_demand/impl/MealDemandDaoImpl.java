package com.alibaba.NetCTOSS.usermag.dao_demand.impl;

import java.util.List;

import javax.annotation.Resource;

import org.apache.ibatis.session.SqlSession;
import org.springframework.stereotype.Repository;

import com.alibaba.NetCTOSS.beans.userAndBusBean.MealBean;
import com.alibaba.NetCTOSS.usermag.dao_demand.IMealDemandDao;
import com.alibaba.NetCTOSS.usermag.mapper_demand.MealMapper;
@Repository
public class MealDemandDaoImpl implements IMealDemandDao {
	@Resource
	private MealMapper mealMapper;
	
	
	/**
	 * 查询所有MealBean，好在页面进行分页
	 * @return mealBean 集合
	 */
	@Override
	public List<MealBean> findAllMealBean() {
		// TODO Auto-generated method stub
		
		return mealMapper.findAllMealBean();
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
	
		return mealMapper.findByMealBeanId(id);
	}
	@Override
	public List<String>  findByfindByMealBeanName(String name) {
		// TODO Auto-generated method stub
		return  mealMapper.findByfindByMealBeanName(name);
	}

}
