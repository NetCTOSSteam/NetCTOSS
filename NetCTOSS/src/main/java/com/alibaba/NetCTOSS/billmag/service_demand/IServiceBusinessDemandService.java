package com.alibaba.NetCTOSS.billmag.service_demand;

import java.util.List;

import com.alibaba.NetCTOSS.beans.billBean.ServiceAndBusinessBean;

/**
 * 服务器 明细 os账户（业务账户） 账单的查询接口
 * @author Administrator
 *
 */
public interface IServiceBusinessDemandService {
	
	/**
	 * 条件查询  bean 为空时  查询全部
	 * @param bean
	 * @return
	 */
	public List<ServiceAndBusinessBean> findAccountDayByBean(ServiceAndBusinessBean bean);
	
	
	
}
