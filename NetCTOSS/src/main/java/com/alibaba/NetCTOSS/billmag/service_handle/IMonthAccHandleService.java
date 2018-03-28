package com.alibaba.NetCTOSS.billmag.service_handle;

import com.alibaba.NetCTOSS.beans.billBean.MonthAndAccountBean;

/**
 * 月账务账单 明细  支付    的操作接口
 * @author Administrator
 *
 */
public interface IMonthAccHandleService {
	
	
	/**
	 * 添加 保存 
	 * @param bean
	 */
	public void saveMonthAndAccountBean(MonthAndAccountBean bean);
	
	/**
	 * 修改
	 * @param bean
	 */
	public void updateMonthAndAccountBean(MonthAndAccountBean bean);
	
	
	
}
