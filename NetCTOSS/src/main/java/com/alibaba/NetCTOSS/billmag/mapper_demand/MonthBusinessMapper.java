package com.alibaba.NetCTOSS.billmag.mapper_demand;

import java.util.List;

import org.apache.ibatis.annotations.Param;

import com.alibaba.NetCTOSS.beans.billBean.MonthAndBusinessBean;

public interface MonthBusinessMapper {
	/**
	 * 模糊查询
	 * @param bean
	 * @return
	 */
	public List<MonthAndBusinessBean> findLikeMonthAndBusinessBean(@Param("bean") MonthAndBusinessBean bean);
	
	/**
	 * 精确查询  可以有id
	 * @param bean
	 * @return
	 */
	public MonthAndBusinessBean findByMonthAndBusinessBean(MonthAndBusinessBean bean);
	
	
	/**
	 * 根据账务账号查询说有业务信息的方法
	 * @param account_acc 账务账号
	 * @return 返回该账务账号下使用的所有业务集合
	 */
	public List<MonthAndBusinessBean> findByServerMothAndBusinessBean(@Param("account") String account_acc);
	
}
