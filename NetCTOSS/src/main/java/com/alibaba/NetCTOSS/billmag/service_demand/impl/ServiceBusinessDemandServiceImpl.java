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
	public List<ServiceAndBusinessBean> findAccountDayByBean(ServiceAndBusinessBean bean) {
		// TODO Auto-generated method stub
		return iServiceBusinessDemandDao.findAccountDayByBean(bean);
	}

}
