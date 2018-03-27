package com.alibaba.NetCTOSS.usermag.dao_handle;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;

import com.alibaba.NetCTOSS.beans.userAndBusBean.BusinessBean;

/**
 * 业务账户的操作接口
 * @author Administrator
 *
 */
public interface IBusinessHandleDao extends JpaRepository<BusinessBean,Integer>,JpaSpecificationExecutor<BusinessBean>  {
	
	
	
	
	
	
}
