package com.alibaba.NetCTOSS.usermag.mapper_demand;

import java.util.List;

import org.apache.ibatis.annotations.Param;

import com.alibaba.NetCTOSS.beans.userAndBusBean.BusinessBean;

public interface BusinessMapper {
	/**
	 * 模糊查询 bean为空查全部
	 * @param bean
	 * @return
	 */
	public List<BusinessBean> findLikeByBean(@Param("bean")BusinessBean bean);
	
	/**
	 * 精确查询 
	 * @param bean
	 * @return
	 */
	public BusinessBean findByBean(@Param("bean")BusinessBean bean);
	
	/**
	 * 根据账务账户 id  查询  出集合 
	 * @param id
	 * @return
	 */
	public List<BusinessBean> findByUserId(@Param("id")int id);
}
