package com.alibaba.NetCTOSS.admmag.service_handle;

import com.alibaba.NetCTOSS.beans.admAndRoleBean.AdministratorBean;

/**
 * 管理员的操作接口
 * @author Administrator
 *
 */
public interface IAdminHandleService {

	void saveAdministratorBean(AdministratorBean administratorBean);

	void updateAdministratorBean(AdministratorBean administratorBean);

	void deleteAdministratorBean(AdministratorBean administratorBean);
}
