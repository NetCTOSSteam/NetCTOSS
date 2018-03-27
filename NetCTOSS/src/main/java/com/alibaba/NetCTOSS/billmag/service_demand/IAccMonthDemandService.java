package com.alibaba.NetCTOSS.billmag.service_demand;

import java.util.List;

import com.alibaba.NetCTOSS.beans.billBean.AccountDayBean;
import com.alibaba.NetCTOSS.beans.billBean.AccountMonthBean;

/**
 * 月账务账单的查询接口
 * @author Administrator
 *
 */
public interface IAccMonthDemandService {
	
	/**
	 * 条件查询  bean 为空时  查询全部
	 * @param bean
	 * @return
	 */
	public List<AccountMonthBean> findAccountDayByBean(AccountMonthBean bean);
	
	
	
	
}
