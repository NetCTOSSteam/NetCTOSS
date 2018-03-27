package com.alibaba.NetCTOSS.billmag.service_handle;

import com.alibaba.NetCTOSS.beans.billBean.AccountMonthBean;

/**
 * 月账务账单的操作接口
 * @author Administrator
 *
 */
public interface IAccMonthHandleService {
	
	/**
	 * 添加 保存 
	 * @param bean
	 */
	public void saveAccountMonthBean(AccountMonthBean bean);
	
	/**
	 * 修改
	 * @param bean
	 */
	public void updateAccountMonthBean(AccountMonthBean bean);
	
	
	
	
}
