package com.alibaba.NetCTOSS.Test;

import javax.annotation.Resource;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import com.alibaba.NetCTOSS.beans.billBean.MonthAndAccountBean;
import com.alibaba.NetCTOSS.billmag.service_demand.IMonthAccDemandService;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations="classpath:applicationContext.xml")
public class MonthAccDemandServiceImplTest {

	@Resource
	private IMonthAccDemandService iMonthAccDemandService;
	
	
	@Test
	public void testFindLikeMonthAndAccountBean() {
		
		MonthAndAccountBean bean = new MonthAndAccountBean();
		System.out.println(iMonthAccDemandService.findLikeMonthAndAccountBean(bean)+"131232");;
	}
}
