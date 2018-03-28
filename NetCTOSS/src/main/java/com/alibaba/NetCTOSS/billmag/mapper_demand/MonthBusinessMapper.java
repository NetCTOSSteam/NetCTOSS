package com.alibaba.NetCTOSS.billmag.mapper_demand;

import java.util.List;

import com.alibaba.NetCTOSS.beans.billBean.MonthAndBusinessBean;

public interface MonthBusinessMapper {
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
