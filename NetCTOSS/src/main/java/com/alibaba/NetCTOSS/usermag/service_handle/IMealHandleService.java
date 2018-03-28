package com.alibaba.NetCTOSS.usermag.service_handle;

import com.alibaba.NetCTOSS.beans.userAndBusBean.MealBean;

/**
 * 资费 的操作接口
 * @author Administrator
 *
 */
public interface IMealHandleService {
	/**
	 * 添加资费信息
	 * @param bean  MealBean
	 */
	public void addMealBean(MealBean bean);
	
	/**
	 *根据id删除资费信息
	 */
	public void deletedByMealBeanID(int id);
	/**
	 * 修改资费信息
	 * @return 修改后的MealBean
	 */
	public void updateMealBean(String name ,int id);
	
}
