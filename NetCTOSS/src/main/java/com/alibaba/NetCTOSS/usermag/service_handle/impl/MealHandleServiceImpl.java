package com.alibaba.NetCTOSS.usermag.service_handle.impl;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import com.alibaba.NetCTOSS.beans.userAndBusBean.MealBean;
import com.alibaba.NetCTOSS.usermag.dao_handle.IMealHandleDao;
import com.alibaba.NetCTOSS.usermag.service_handle.IMealHandleService;
import com.alibaba.NetCTOSS.util.MyLog;
@Service
public class MealHandleServiceImpl implements IMealHandleService {
	@Resource
	private IMealHandleDao mealHandleDao;
	/**
	 * 添加资费信息
	 * @param bean  MealBean
	 */
	@MyLog(place="资费管理模块",action="添加")
	@Override
	public void addMealBean(MealBean bean) {
		// TODO Auto-generated method stub
		mealHandleDao.save(bean);
	}
	/**
	 *根据id删除资费信息
	 */
	@MyLog(place="资费管理模块",action="删除")
	@Override
	public void deletedByMealBeanID(int id) {
		// TODO Auto-generated method stub
		mealHandleDao.deletedByMealBeanID(id);
	}
	/**
	 * 修改资费信息
	 * @return 修改后的MealBean
	 */
	@MyLog(place="资费管理模块",action="修改")
	@Override
	public void updateMealBean(MealBean bean) {
		// TODO Auto-generated method stub
		mealHandleDao.saveAndFlush(bean);
		
	}
	
}
