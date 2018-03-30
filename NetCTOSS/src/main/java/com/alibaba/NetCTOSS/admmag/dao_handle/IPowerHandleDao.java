package com.alibaba.NetCTOSS.admmag.dao_handle;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.data.jpa.repository.Query;

import com.alibaba.NetCTOSS.beans.admAndRoleBean.PowerBean;

/**
 * 权限的操作接口
 * @author Administrator
 *
 */
public interface IPowerHandleDao extends JpaRepository<PowerBean,Integer>,JpaSpecificationExecutor<PowerBean>{
	
	/**
	 * 通过权限名来找到对应的权限对象
	 * @param powerName
	 * @return
	 */
	@Query("from PowerBean where powerName = ?")
	public PowerBean findPowerBeanByPowerName(String powerName);
	
}
