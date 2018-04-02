package com.alibaba.NetCTOSS.admmag.dao_handle;

import org.springframework.data.jpa.repository.JpaRepository;

import com.alibaba.NetCTOSS.beans.admAndRoleBean.AdministratorBean;

/**
 * 管理员的操作接口
 * @author Administrator
 *
 */
public interface IAdminHandleDao extends JpaRepository<AdministratorBean, Integer>{


	
	

	
}
