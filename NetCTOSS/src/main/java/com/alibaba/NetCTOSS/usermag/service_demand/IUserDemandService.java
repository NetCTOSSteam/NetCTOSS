package com.alibaba.NetCTOSS.usermag.service_demand;

import java.util.List;

import com.alibaba.NetCTOSS.beans.userAndBusBean.UserBean;

/**
 * 用户 账务账户 的查询接口
 * @author Administrator
 *
 */
public interface IUserDemandService {
	
	/**
	 * 模糊查询 bean为空查全部
	 * @param bean
	 * @return
	 */
	public List<UserBean> findLikeByBean(UserBean bean);
	
	/**
	 * 精确查询 
	 * @param bean
	 * @return
	 */
	public UserBean findByBean(UserBean bean);
	
}
