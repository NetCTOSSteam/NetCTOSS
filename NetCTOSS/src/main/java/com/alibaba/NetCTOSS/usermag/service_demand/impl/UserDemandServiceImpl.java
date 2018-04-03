package com.alibaba.NetCTOSS.usermag.service_demand.impl;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import com.alibaba.NetCTOSS.beans.admAndRoleBean.RoleBean;
import com.alibaba.NetCTOSS.beans.billBean.AccountYearBillBean;
import com.alibaba.NetCTOSS.beans.userAndBusBean.BusinessBean;
import com.alibaba.NetCTOSS.beans.userAndBusBean.UserBean;
import com.alibaba.NetCTOSS.usermag.dao_demand.IBusinessDemandDao;
import com.alibaba.NetCTOSS.usermag.dao_demand.IUserDemandDao;
import com.alibaba.NetCTOSS.usermag.service_demand.IUserDemandService;

@Service
public class UserDemandServiceImpl implements IUserDemandService {

	@Resource
	private IUserDemandDao iUserDemandDao; 
	@Resource 
	private IBusinessDemandDao iBusinessDemandDao;
	@Override
	public List<UserBean> findLikeByBean(UserBean bean) {
		// TODO Auto-generated method stub
		List<UserBean> b = iUserDemandDao.findLikeByBean(bean);
		for (UserBean userBean : b) {
			if(userBean.getId() != null) {
				userBean.setBusinessBeans(getSetBus(userBean.getId()));
			}
		}
		return b;
	}

	@Override
	public UserBean findByBean(UserBean bean) {
		// TODO Auto-generated method stub
		
		UserBean b = iUserDemandDao.findByBean(bean);
		b.setBusinessBeans(getSetBus(b.getId()));
		
		return b;
	}
	/**
	 * 有个集合  由于是set  需要后面来进行修改
	 */
	private Set<BusinessBean> getSetBus(int id){
		
		List<BusinessBean> li = iBusinessDemandDao.findByUserId(id);
		
		Set<BusinessBean> set= new HashSet<BusinessBean>(li);
		
		return set;
		
	}

	@Override
	public UserBean findByLoginName(String loginName) {
		// TODO Auto-generated method stub
		return iUserDemandDao.findByLoginName(loginName);
	}

	@Override
	public RoleBean getRole(String userLoginName) {
		// TODO Auto-generated method stub
		return iUserDemandDao.getRole(userLoginName);
	}

	@Override
	public List<UserBean> findAllUserBean() {
		// TODO Auto-generated method stub
		return iUserDemandDao.findAllUserBean();
	}

	@Override
	public List<AccountYearBillBean> findByAccountYearBillBeanByAccoundName(String accoundName) {
		// TODO Auto-generated method stub
		return iUserDemandDao.findByAccountYearBillBeanByAccoundName(accoundName);
	}
}
