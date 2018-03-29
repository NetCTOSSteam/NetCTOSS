package com.alibaba.NetCTOSS.admmag.dao_handle;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;

import com.alibaba.NetCTOSS.beans.admAndRoleBean.PowerBean;

/**
 * 权限的操作接口
 * @author Administrator
 *
 */
public interface IPowerHandleDao extends JpaRepository<PowerBean,Integer>,JpaSpecificationExecutor<PowerBean>{
	
	
	
}
