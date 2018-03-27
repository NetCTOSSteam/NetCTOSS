package com.alibaba.NetCTOSS.usermag.mapper_demand;

import java.util.List;

import com.alibaba.NetCTOSS.beans.userAndBusBean.BusinessBean;
import com.alibaba.NetCTOSS.beans.userAndBusBean.UserBean;

public interface UserMapper {
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
