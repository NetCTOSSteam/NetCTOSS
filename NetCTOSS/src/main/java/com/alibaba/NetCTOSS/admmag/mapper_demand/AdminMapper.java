package com.alibaba.NetCTOSS.admmag.mapper_demand;

import java.util.List;

import org.apache.ibatis.annotations.Param;

import com.alibaba.NetCTOSS.beans.admAndRoleBean.AdministratorBean;
import com.alibaba.NetCTOSS.beans.admAndRoleBean.RoleBean;

public interface AdminMapper {
	/**
	 * 根据传入的参数   进行查询管理员集合  参数为管理员对象
	 * @param administratorBean 管理员对象
	 * @return 管理员集合 
	 */
	List<AdministratorBean> findAllAdministratorBeansByParam(@Param("administratorBean")AdministratorBean administratorBean);
	
	
	/**
	 * 通过管理员的登录名获取管理员对象
	 * @param adminName
	 * @return
	 */
	public AdministratorBean findAdminByAdminLoginName(@Param("adminLoginName")String adminLoginName);

	/**
	 * 通过管理员登录名查找角色信息
	 * @param adminLoginName
	 * @return
	 */
	public RoleBean getRole(@Param("adminLoginName")String adminLoginName);


	AdministratorBean findAdministratorBeanById(@Param("id") int id);

}
