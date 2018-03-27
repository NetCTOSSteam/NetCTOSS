package com.alibaba.NetCTOSS.usermag.dao_handle;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;

import com.alibaba.NetCTOSS.beans.userAndBusBean.UserBean;

/**
 * 用户 账务账户 的操作接口
 * @author Administrator
 *
 */
public interface IUserHandleDao extends JpaRepository<UserBean,Integer>,JpaSpecificationExecutor<UserBean> {
	
	
	
	
	
	
}
