package com.alibaba.NetCTOSS.billmag.mapper_demand;

import java.util.List;

import org.apache.ibatis.annotations.Param;

import com.alibaba.NetCTOSS.beans.billBean.AccountMonthBean;

public interface AccMonthMapper {
	/**
	 * 条件查询  bean 为空时  查询全部
	 * @param bean
	 * @return
	 */
	public List<AccountMonthBean> findAccountDayByBean(@Param("bean")AccountMonthBean bean);
	
}
