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
	
	
	/**
	 * 根据资费套餐查询业务账单信息
	 * @param tariff 资费套餐的名字
	 * @return 返回所有包含该名字的套餐集合
	 */
	public List<MonthAndBusinessBean> findByServerMothAndBusinessBeanTariff(String tariff);
	
	
	/**
	 * 查询所有业务中使用的资费套餐名字
	 * @return 
	 */
	public List<MonthAndBusinessBean> findByServerMothAndBusinessBeanAllTariff();
	
	/**
	 * 通过年份和账务账号查询出该账号下面的所有业务账号的费用信息
	 * @param account
	 * @param year
	 * @return
	 */
	public List<MonthAndBusinessBean> findAllMonthBussinessByAccAndYear(@Param("account")String account,@Param("year")int year);
}
