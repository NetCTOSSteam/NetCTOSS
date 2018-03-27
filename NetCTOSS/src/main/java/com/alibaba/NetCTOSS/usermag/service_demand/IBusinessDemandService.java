package com.alibaba.NetCTOSS.usermag.service_demand;

import java.util.List;

import com.alibaba.NetCTOSS.beans.userAndBusBean.BusinessBean;

/**
 * 业务账户的查询接口
 * @author Administrator
 *
 */
public interface IBusinessDemandService {
	
	/**
	 * 模糊查询 bean为空查全部
	 * @param bean
	 * @return
	 */
	public List<BusinessBean> findLikeByBean(BusinessBean bean);
	
	/**
	 * 精确查询 
	 * @param bean
	 * @return
	 */
	public BusinessBean findByBean(BusinessBean bean);
	 
	/**
	 * 根据账务账户 id  查询  出集合 
	 * @param id
	 * @return
	 */
	public List<BusinessBean> findByUserId(int id);
	
}
