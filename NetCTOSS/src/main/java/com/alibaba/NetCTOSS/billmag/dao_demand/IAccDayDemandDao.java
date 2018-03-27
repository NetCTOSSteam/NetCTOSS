package com.alibaba.NetCTOSS.billmag.dao_demand;

import java.util.List;

import com.alibaba.NetCTOSS.beans.billBean.AccountDayBean;

/**
 * 日账务账单的查询接口
 * @author Administrator
 *
 */
public interface IAccDayDemandDao {
	
	/**
	 * 条件查询  bean 为空时  查询全部
	 * @param bean
	 * @return
	 */
	public List<AccountDayBean> findAccountDayByBean(AccountDayBean bean);
	
	
}
