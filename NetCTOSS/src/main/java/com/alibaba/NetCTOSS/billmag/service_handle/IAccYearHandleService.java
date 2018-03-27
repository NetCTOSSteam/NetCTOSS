package com.alibaba.NetCTOSS.billmag.service_handle;

import com.alibaba.NetCTOSS.beans.billBean.AccountYearBillBean;

/**
 * 年账务账单的操作接口
 * @author Administrator
 *
 */
public interface IAccYearHandleService {
	
	/**
	 * 添加 保存 
	 * @param bean
	 */
	public void saveAccountYearBean(AccountYearBillBean bean);
	
	/**
	 * 修改
	 * @param bean
	 */
	public void updateAccountYearBean(AccountYearBillBean bean);
}
