package com.alibaba.NetCTOSS.admmag.dao_handle;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;

import com.alibaba.NetCTOSS.beans.admAndRoleBean.RoleBean;

/**
 * 角色的操作接口
 * @author Administrator
 *
 */
public interface IRoleHandleDao extends JpaRepository<RoleBean,Integer>,JpaSpecificationExecutor<RoleBean>{
	
	
	
	
}
