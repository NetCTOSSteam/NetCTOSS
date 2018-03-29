package com.alibaba.NetCTOSS.admmag.service_handle;

import com.alibaba.NetCTOSS.beans.admAndRoleBean.PowerBean;

/**
 * 权限的操作接口
 * @author Administrator
 *
 */
public interface IPowerHandleService {
	
	/**
	 * 添加权限信息
	 * @param power
	 */
	public void savePowerBean(PowerBean power);
	
	/**
	 * 修改权限信息
	 * @param power
	 */
	public void updatePowerBean(PowerBean power);
	
	/**
	 * 删除权限信息
	 * @param power
	 */
	public void deletePowerBean(PowerBean power);
}
