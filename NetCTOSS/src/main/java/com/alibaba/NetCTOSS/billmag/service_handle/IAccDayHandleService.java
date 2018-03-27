package com.alibaba.NetCTOSS.billmag.service_handle;

import com.alibaba.NetCTOSS.beans.billBean.AccountDayBean;

/**
 * 日账务账单的操作接口
 * @author Administrator
 *
 */
public interface IAccDayHandleService {
	
	/**
	 * 添加 保存 
	 * @param bean
	 */
	public void saveAccountDayBean(AccountDayBean bean);
	
	/**
	 * 修改
	 * @param bean
	 */
	public void updateAccountDayBean(AccountDayBean bean);
	
	
	
	
	
}
