package com.alibaba.NetCTOSS.admmag.dao_handle;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.data.jpa.repository.Query;

import com.alibaba.NetCTOSS.beans.admAndRoleBean.RoleBean;

/**
 * 角色的操作接口
 * @author Administrator
 *
 */
public interface IRoleHandleDao extends JpaRepository<RoleBean,Integer>,JpaSpecificationExecutor<RoleBean>{
	
	
	/**
	 * 通过id查找role对象
	 * @param id
	 * @return
	 */
	@Query("FROM RoleBean where id = ?")
	public RoleBean findById(int id);
	
}
