package com.alibaba.NetCTOSS.logmag.dao_handle;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;

import com.alibaba.NetCTOSS.beans.logBean.LoginExitBean;

/**
 * 登录日志 操作
 * @author Administrator
 *
 */
public interface ILoginExitHandleDao extends JpaRepository<LoginExitBean, Integer>,JpaSpecificationExecutor<LoginExitBean>{
	
	
	
	
	
}
