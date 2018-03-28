package com.alibaba.NetCTOSS.billmag.mapper_demand;

import java.util.List;

import com.alibaba.NetCTOSS.beans.billBean.MonthAndAccountBean;

public interface MonthAccMapper {
	/**
	 * 模糊查询
	 * @param bean
	 * @return
	 */
	public List<MonthAndAccountBean> findLikeMonthAndAccountBean (MonthAndAccountBean bean);
	
	/**
	 * 精确查询  可以有id
	 * @param bean
	 * @return
	 */
	public MonthAndAccountBean findByMonthAndAccountBean (MonthAndAccountBean bean);
}
