package com.alibaba.NetCTOSS.billmag.dao_handle;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;

import com.alibaba.NetCTOSS.beans.billBean.MonthAndBusinessBean;

/**
 * 月业务账单明细的操作接口
 * @author Administrator
 *
 */
public interface IMonthBusinessHandleDao extends JpaRepository<MonthAndBusinessBean,Integer>,JpaSpecificationExecutor<MonthAndBusinessBean>{
	
	
	
	
	
}
