package com.alibaba.NetCTOSS.usermag.dao_demand.impl;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Repository;

import com.alibaba.NetCTOSS.beans.userAndBusBean.BusinessBean;
import com.alibaba.NetCTOSS.beans.userAndBusBean.UserBean;
import com.alibaba.NetCTOSS.usermag.dao_demand.IUserDemandDao;
import com.alibaba.NetCTOSS.usermag.mapper_demand.UserMapper;
@Repository
public class UserDemandDaoImpl implements IUserDemandDao {

	@Resource
	private UserMapper userMapper;
	@Override
	public List<UserBean> findLikeByBean(UserBean bean) {
		// TODO Auto-generated method stub
		return userMapper.findLikeByBean(bean);
	}

	@Override
	public UserBean findByBean(UserBean bean) {
		// TODO Auto-generated method stub
		return userMapper.findByBean(bean);
	}


}
