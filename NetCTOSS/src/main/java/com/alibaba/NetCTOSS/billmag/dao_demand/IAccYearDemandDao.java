package com.alibaba.NetCTOSS.billmag.dao_demand;

import java.util.List;

import com.alibaba.NetCTOSS.beans.billBean.AccountYearBillBean;

/**
 * 年账务账单的查询接口
 * @author Administrator
 *
 */
public interface IAccYearDemandDao {
	
	
	/**
	 * 条件查询  bean 为空时  查询全部
	 * @param bean
	 * @return
	 */
	public List<AccountYearBillBean> findAccountDayByBean(AccountYearBillBean bean);
	
	
	
}
