package com.alibaba.NetCTOSS.usermag.mapper_demand;

import java.util.List;

import org.springframework.data.repository.query.Param;

import com.alibaba.NetCTOSS.beans.admAndRoleBean.RoleBean;
import com.alibaba.NetCTOSS.beans.billBean.AccountYearBillBean;
import com.alibaba.NetCTOSS.beans.userAndBusBean.UserBean;

public interface UserMapper {
	/**
	 * 模糊查询 bean为空查全部
	 * @param bean
	 * @return
	 */
	public List<UserBean> findLikeByBean(@Param("user") UserBean user);
	
	/**
	 * 精确查询 
	 * @param bean
	 * @return
	 */
	public UserBean findByBean(@Param("bean")UserBean bean);
	
	/**
	 * 查询所有账务账号
	 * @return
	 */
	public List<UserBean> findAllUserBean();
	
	/**
	 * 通过用户名查找用户对象
	 * @param loginName
	 * @return
	 */
	public UserBean findByLoginName(@Param("loginName")String loginName);
	
	
	/**
	 * 通过用户登录名查找角色信息
	 * @param adminLoginName
	 * @return
	 */
	public RoleBean getRole(@Param("userLoginName")String userLoginName);
	
	/**
	 * 通过账务账号名查询年度账务
	 * @param accoundName
	 * @return
	 */
	public List<AccountYearBillBean> findByAccountYearBillBeanByAccoundName(@Param("accoundName")String accoundName);
}
