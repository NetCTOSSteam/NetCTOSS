package com.alibaba.NetCTOSS.billmag.service_demand.impl;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import com.alibaba.NetCTOSS.beans.billBean.ServiceAndBusinessBean;
import com.alibaba.NetCTOSS.billmag.dao_demand.IServiceBusinessDemandDao;
import com.alibaba.NetCTOSS.billmag.service_demand.IServiceBusinessDemandService;

@Service
public class ServiceBusinessDemandServiceImpl implements IServiceBusinessDemandService {

	@Resource
	private IServiceBusinessDemandDao iServiceBusinessDemandDao;
	@Override
	public List<ServiceAndBusinessBean> findServiceBusByBean(ServiceAndBusinessBean bean) {
		// TODO Auto-generated method stub
		return iServiceBusinessDemandDao.findAccountDayByBean(bean);
	}

	/**
	 * 根据账务账号（即OS账号）查询该业务下面服务器的详细信息
	 * @param f_os_account os账号
	 * @return 返回服务器信息对象
	 */
	public ServiceAndBusinessBean findOneServiceBusByBean(String f_os_account) {
		return null;
	}
}
