package com.alibaba.NetCTOSS.usermag.service_handle.impl;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import com.alibaba.NetCTOSS.beans.userAndBusBean.BusinessBean;
import com.alibaba.NetCTOSS.usermag.dao_handle.IBusinessHandleDao;
import com.alibaba.NetCTOSS.usermag.service_handle.IBusinessHandleService;
import com.alibaba.NetCTOSS.util.MyLog;
@Service
public class BusinessHandleServiceImpl implements IBusinessHandleService {

	@Resource
	private IBusinessHandleDao iBusinessHandleDao;
	
	@Override
	@MyLog(place="业务账号管理模块",action="添加")
	public void saveBusinessBean(BusinessBean bean) {
		// TODO Auto-generated method stub
		iBusinessHandleDao.save(bean);
	}

	@Override
	@MyLog(place="业务账号管理模块",action="修改")
	public void updateBusinessBean(BusinessBean bean) {
		// TODO Auto-generated method stub
		iBusinessHandleDao.saveAndFlush(bean);
	}

	@Override
	@MyLog(place="业务账号管理模块",action="删除")
	public void deleteBusinessBean(BusinessBean bean) {
		// TODO Auto-generated method stub
		iBusinessHandleDao.saveAndFlush(bean);
	}

}
