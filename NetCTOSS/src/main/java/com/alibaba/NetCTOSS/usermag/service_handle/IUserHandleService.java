package com.alibaba.NetCTOSS.usermag.service_handle;

import com.alibaba.NetCTOSS.beans.userAndBusBean.BusinessBean;
import com.alibaba.NetCTOSS.beans.userAndBusBean.UserBean;

/**
 * 用户 账务账户 的操作接口
 * @author Administrator
 *
 */
public interface IUserHandleService {
	
	/**
	 * 保存添加一个 BusinessBean.java类
	 * @param bean
	 */
	public void saveUserBean(UserBean bean);
	
	/**
	 *  修改 基本数据  与 数据资费状态
	 * @param bean
	 */
	public void updateUserBean(UserBean bean);
	
	/**
	 * 删除 即修改 有效表示
	 * @param bean
	 */
	public void deleteUserBean(UserBean bean);
}
