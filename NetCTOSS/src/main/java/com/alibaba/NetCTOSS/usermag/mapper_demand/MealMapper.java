package com.alibaba.NetCTOSS.usermag.mapper_demand;

import java.util.List;

import org.apache.ibatis.annotations.Param;

import com.alibaba.NetCTOSS.beans.userAndBusBean.MealBean;

public interface MealMapper {
	/**
	 * 查询所有MealBean，好在页面进行分页
	 * @return mealBean 集合
	 */
	public List<MealBean> findAllMealBean();
	
	/**
	 * 根据ID查询MealBean 
	 * 查询出根据MealBean的资费状态判断能否进行操作
	 * @param id mealBean ID
	 * @return MealBean
	 */
	public MealBean findByMealBeanId(@Param("mealId")int id);
	/**
	 * 根据名字查是否有相同的名字
	 * @param name MealBeanName
	 * @return
	 */
	public List<String> findByfindByMealBeanName(@Param("mealName")String name);
}
