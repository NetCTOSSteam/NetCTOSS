package com.alibaba.NetCTOSS.admmag.mapper_demand;

import java.util.List;
import java.util.Map;
import java.util.Set;

import org.springframework.data.repository.query.Param;

import com.alibaba.NetCTOSS.beans.admAndRoleBean.PowerBean;

public interface PowerMapper {
	/**
	 * 查询所有的权限信息
	 * @return
	 */
	public Set<PowerBean> findAllPowers();
	
	/**
	 * 根据参数查询权限信息
	 * @param param
	 * @return
	 */
	public List<PowerBean> findPowersByCondition(@Param("param")Map<String, String> param);
}
