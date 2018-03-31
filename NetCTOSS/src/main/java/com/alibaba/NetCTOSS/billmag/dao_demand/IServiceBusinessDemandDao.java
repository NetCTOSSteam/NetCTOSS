package com.alibaba.NetCTOSS.billmag.dao_demand;

import java.util.List;

import com.alibaba.NetCTOSS.beans.billBean.ServiceAndBusinessBean;

/**
 * 服务器 明细 os账户（业务账户） 账单的查询接口
 * @author Administrator
 *
 */
public interface IServiceBusinessDemandDao {
	
	
	/**
	 * 条件查询  bean 为空时  查询全部
	 * @param bean
	 * @return
	 */
	public List<ServiceAndBusinessBean> findAccountDayByBean(ServiceAndBusinessBean bean);
	
	
	/**
	 * 根据账务账号（即OS账号）查询该业务下面服务器的详细信息
	 * @param f_os_account os账号
	 * @return 返回服务器信息对象
	 */
	public ServiceAndBusinessBean findOneServiceBusByBean(String f_os_account);
}
