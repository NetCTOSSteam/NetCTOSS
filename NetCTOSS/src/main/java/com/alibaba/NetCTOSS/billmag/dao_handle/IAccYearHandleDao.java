package com.alibaba.NetCTOSS.billmag.dao_handle;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;

import com.alibaba.NetCTOSS.beans.billBean.AccountYearBillBean;

/**
 * 年账务账单的操作接口
 * @author Administrator
 *
 */

public interface IAccYearHandleDao extends JpaRepository<AccountYearBillBean,Integer>,JpaSpecificationExecutor<AccountYearBillBean>{
	
	
	
}
