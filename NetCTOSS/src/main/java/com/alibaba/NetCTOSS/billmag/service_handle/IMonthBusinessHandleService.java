package com.alibaba.NetCTOSS.billmag.service_handle;

import com.alibaba.NetCTOSS.beans.billBean.MonthAndBusinessBean;

/**
 * 月业务账单明细的操作接口
 * @author Administrator
 *
 */
public interface IMonthBusinessHandleService {
	
	
	/**
	 * 添加 保存 
	 * @param bean
	 */
	public void saveMonthAndBusinessBean(MonthAndBusinessBean bean);
	
	/**
	 * 修改
	 * @param bean
	 */
	public void updateMonthAndBusinessBean(MonthAndBusinessBean bean);
	
	
	
}
