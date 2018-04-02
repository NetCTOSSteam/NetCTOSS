package com.alibaba.NetCTOSS.usermag.dao_demand;

import java.util.List;

import com.alibaba.NetCTOSS.beans.userAndBusBean.MealBean;

/**
 * 资费 的查询接口
 * @author Administrator
 *
 */
public interface IMealDemandDao {
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
	public MealBean findByMealBeanId(int id);
	/**
	 * 根据名字查是否有相同的名字
	 * @param name MealBeanName
	 * @return
	 */
	public List<String>  findByfindByMealBeanName(String name);
}
