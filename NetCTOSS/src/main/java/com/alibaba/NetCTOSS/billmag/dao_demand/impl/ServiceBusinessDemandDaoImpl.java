package com.alibaba.NetCTOSS.billmag.dao_demand.impl;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Repository;

import com.alibaba.NetCTOSS.beans.billBean.ServiceAndBusinessBean;
import com.alibaba.NetCTOSS.billmag.dao_demand.IServiceBusinessDemandDao;
import com.alibaba.NetCTOSS.billmag.mapper_demand.ServiceBusinessMapper;

@Repository
public class ServiceBusinessDemandDaoImpl implements IServiceBusinessDemandDao {

	@Resource
	private ServiceBusinessMapper serviceBusinessMapper;
	@Override
	public List<ServiceAndBusinessBean> findAccountDayByBean(ServiceAndBusinessBean bean) {
		// TODO Auto-generated method stub
		return serviceBusinessMapper.findServiceBusByBean(bean);
	}
	@Override
	public ServiceAndBusinessBean findOneServiceBusByBean(String f_os_account) {
		// TODO Auto-generated method stub
		return serviceBusinessMapper.findOneServiceBusByBean(f_os_account);
	}

}
