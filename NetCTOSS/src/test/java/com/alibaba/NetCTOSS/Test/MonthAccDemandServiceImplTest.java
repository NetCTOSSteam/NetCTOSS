package com.alibaba.NetCTOSS.Test;

import javax.annotation.Resource;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import com.alibaba.NetCTOSS.admmag.service_demand.IAdminDemandService;
import com.alibaba.NetCTOSS.admmag.service_handle.IAdminHandleService;
import com.alibaba.NetCTOSS.beans.admAndRoleBean.AdministratorBean;
import com.alibaba.NetCTOSS.beans.billBean.MonthAndAccountBean;
import com.alibaba.NetCTOSS.beans.userAndBusBean.UserBean;
import com.alibaba.NetCTOSS.billmag.service_demand.IMonthAccDemandService;
import com.alibaba.NetCTOSS.usermag.dao_demand.IUserDemandDao;
import com.alibaba.NetCTOSS.usermag.mapper_demand.UserMapper;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations="classpath:applicationContext.xml")
public class MonthAccDemandServiceImplTest {

	@Resource
	private IMonthAccDemandService iMonthAccDemandService;
	
	
	@Resource
	private IAdminDemandService adminDemandServiceImpl;
	@Resource
	private IAdminHandleService adminHandleServiceImpl;
	
	@Resource
	private IUserDemandDao userDemandDaoImpl;
	
	@Test
	public void testFindLikeByBean() {
		UserBean user = new UserBean();
		userDemandDaoImpl.findLikeByBean(user);
	}
	
	
	@Test
	public void fin() {
		int id = 1;
		AdministratorBean admin = adminDemandServiceImpl.findAdministratorBeanById(id);
		admin.setStatus(0);
		adminHandleServiceImpl.deleteAdministratorBean(admin);
	}
	
	@Test
	public void testFindAllAdministratorBeansByParam() {
		AdministratorBean administratorBean = new AdministratorBean();
		
		System.out.println(adminDemandServiceImpl.findAllAdministratorBeansByParam(administratorBean));;
		
	}
	
	@Test
	public void testFindLikeMonthAndAccountBean() {
		
		MonthAndAccountBean bean = new MonthAndAccountBean();
		System.out.println(iMonthAccDemandService.findLikeMonthAndAccountBean(bean)+"131232");;
	}
	
}
