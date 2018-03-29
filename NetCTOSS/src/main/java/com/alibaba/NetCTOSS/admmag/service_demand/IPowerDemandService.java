package com.alibaba.NetCTOSS.admmag.service_demand;

import java.util.Set;

import com.alibaba.NetCTOSS.beans.admAndRoleBean.PowerBean;

/**
 * 权限的查询接口
 * @author Administrator
 *
 */
public interface IPowerDemandService {
	
	
	/**
	 * 查询所有的权限信息
	 * @return
	 */
	public Set<PowerBean> findAllPowers();
}
