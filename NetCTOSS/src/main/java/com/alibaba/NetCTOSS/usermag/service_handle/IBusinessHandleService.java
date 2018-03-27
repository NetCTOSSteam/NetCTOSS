package com.alibaba.NetCTOSS.usermag.service_handle;

import com.alibaba.NetCTOSS.beans.userAndBusBean.BusinessBean;

/**
 * 业务账户的操作接口
 * @author Administrator
 *
 */
public interface IBusinessHandleService {
	
	/**
	 * 保存添加一个 BusinessBean.java类
	 * @param bean
	 */
	public void saveBusinessBean(BusinessBean bean);
	
	/**
	 *  修改 基本数据  与 数据资费状态
	 * @param bean
	 */
	public void updateBusinessBean(BusinessBean bean);
	
	/**
	 * 删除 即修改 有效表示
	 * @param bean
	 */
	public void deleteBusinessBean(BusinessBean bean);
}
