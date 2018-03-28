package com.alibaba.NetCTOSS.billmag.dao_handle;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;

import com.alibaba.NetCTOSS.beans.billBean.MonthAndAccountBean;

/**
 * 月账务账单 明细  支付    的操作接口
 * @author Administrator
 *
 */
public interface IMonthAccHandleDao extends JpaRepository<MonthAndAccountBean,Integer>,JpaSpecificationExecutor<MonthAndAccountBean> {
	
	
	
	
	
}
