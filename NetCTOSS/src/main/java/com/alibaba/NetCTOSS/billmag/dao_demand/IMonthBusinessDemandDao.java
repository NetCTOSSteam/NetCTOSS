package com.alibaba.NetCTOSS.billmag.dao_demand;

import java.util.List;

import com.alibaba.NetCTOSS.beans.billBean.MonthAndBusinessBean;

/**
 * 月业务账单明细的查询接口
 * @author Administrator
 *
 */
public interface IMonthBusinessDemandDao {
	
	/**
	 * 模糊查询
	 * @param bean
	 * @return
	 */
	public List<MonthAndBusinessBean> findLikeMonthAndBusinessBean(MonthAndBusinessBean bean);
	
	/**
	 * 精确查询  可以有id
	 * @param bean
	 * @return
	 */
	public MonthAndBusinessBean findByMonthAndBusinessBean(MonthAndBusinessBean bean);
	
	
	
	
}
