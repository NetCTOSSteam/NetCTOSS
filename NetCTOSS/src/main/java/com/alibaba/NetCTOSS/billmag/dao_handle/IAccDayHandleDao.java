package com.alibaba.NetCTOSS.billmag.dao_handle;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.stereotype.Repository;

import com.alibaba.NetCTOSS.beans.billBean.AccountDayBean;

/**
 * 日账务账单的操作接口
 * @author Administrator
 *
 */
@Repository
public interface IAccDayHandleDao extends JpaRepository<AccountDayBean,Integer>,JpaSpecificationExecutor<AccountDayBean> {
		
	
}
