package com.alibaba.NetCTOSS.billmag.mapper_demand;

import java.util.List;

import org.apache.ibatis.annotations.Param;

import com.alibaba.NetCTOSS.beans.billBean.MonthAndAccountBean;

public interface MonthAccMapper {
	/**
	 * 模糊查询
	 * @param bean
	 * @return
	 */
	public List<MonthAndAccountBean> findLikeMonthAndAccountBean (@Param("bean") MonthAndAccountBean bean);
	

	/**
	 * 得到排重后的年集合
	 * @return 
	 */
	public List<Integer> getYear();
	
	/**
	 * 得到排重后的月集合
	 * @return 
	 */
	public List<Integer> getMonth();


	/**
	 * 精确查询
	 * @param maab
	 * @return
	 */
	public MonthAndAccountBean findByMonthAndAccountBean(@Param("bean")MonthAndAccountBean bean);
	
	/**
	 * 通过账务账单号和年份查询概念所有月份的账单信息
	 * @param year
	 * @param account
	 * @return
	 */
	public List<MonthAndAccountBean> findByYearAndAccount(@Param("year")int year,@Param("account")String account);
}
