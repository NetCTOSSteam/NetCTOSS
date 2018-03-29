package com.alibaba.NetCTOSS.admmag.mapper_demand;

import java.util.Set;

import com.alibaba.NetCTOSS.beans.admAndRoleBean.PowerBean;

public interface PowerMapper {
	/**
	 * 查询所有的权限信息
	 * @return
	 */
	public Set<PowerBean> findAllPowers();
}
