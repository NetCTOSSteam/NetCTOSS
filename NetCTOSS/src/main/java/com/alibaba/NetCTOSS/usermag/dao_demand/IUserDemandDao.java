package com.alibaba.NetCTOSS.usermag.dao_demand;

import java.util.List;

import com.alibaba.NetCTOSS.beans.userAndBusBean.BusinessBean;
import com.alibaba.NetCTOSS.beans.userAndBusBean.UserBean;

/**
 * 用户 账务账户 的查询接口
 * @author Administrator
 *
 */
public interface IUserDemandDao {
	
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
