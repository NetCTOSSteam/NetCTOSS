package com.alibaba.NetCTOSS.billmag.dao_demand;

import java.util.List;

import com.alibaba.NetCTOSS.beans.billBean.MonthAndAccountBean;

/**
 * 月账务账单 明细  支付    的查询接口
 * @author Administrator
 *
 */
public interface IMonthAccDemandDao {
	
	
	/**
	 * 模糊查询
	 * @param bean
	 * @return
	 */
	public List<MonthAndAccountBean> findLikeMonthAndAccountBean (MonthAndAccountBean bean);
	
	/**
	 * 得到排重后的  所有年  集合
	 * @return
	 */
	public List<Integer> getYear();
	
	/**
	 * 得到排重后的  所有月  集合
	 * @return
	 */
	public List<Integer> getMonth();

	public MonthAndAccountBean findByMonthAndAccountBean(MonthAndAccountBean maab);
	
	
	
}
