package com.alibaba.NetCTOSS.usermag.dao_demand;

import java.util.List;

import com.alibaba.NetCTOSS.beans.admAndRoleBean.RoleBean;
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
	 * 查询所有userbean
	 * @return
	 */
	public List<UserBean> findAllUserBean();
	
	/**
	 * 精确查询 
	 * @param bean
	 * @return
	 */
	public UserBean findByBean(UserBean bean);
	
	
	/**
	 * 通过用户名查找用户对象
	 * @param loginName
	 * @return
	 */
	public UserBean findByLoginName(String loginName);
	
	
	/**
	 * 通过用户登录名查找角色信息
	 * @param adminLoginName
	 * @return
	 */
	public RoleBean getRole(String userLoginName);
}
