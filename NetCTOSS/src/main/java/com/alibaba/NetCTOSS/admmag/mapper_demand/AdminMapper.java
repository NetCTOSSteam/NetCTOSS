package com.alibaba.NetCTOSS.admmag.mapper_demand;

import java.util.List;

import com.alibaba.NetCTOSS.beans.admAndRoleBean.AdministratorBean;

public interface AdminMapper {
	/**
	 * 根据传入的参数   进行查询管理员集合  参数为管理员对象
	 * @param administratorBean 管理员对象
	 * @return 管理员集合 
	 */
	List<AdministratorBean> findAllAdministratorBeansByParam(AdministratorBean administratorBean);
}
