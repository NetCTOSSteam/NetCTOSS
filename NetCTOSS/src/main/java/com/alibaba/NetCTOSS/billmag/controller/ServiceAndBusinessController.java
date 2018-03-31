package com.alibaba.NetCTOSS.billmag.controller;

import javax.annotation.Resource;

import org.springframework.data.repository.query.Param;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.alibaba.NetCTOSS.beans.billBean.ServiceAndBusinessBean;
import com.alibaba.NetCTOSS.billmag.service_demand.IServiceBusinessDemandService;

@RestController
@RequestMapping("/serviceAndBusiness")
public class ServiceAndBusinessController {
	 
		@Resource
		private IServiceBusinessDemandService  serviceBusinessDemandServiceImpl;
		
		@RequestMapping(value = "/one", method = { RequestMethod.GET }, produces = { "application/json" })
		public ServiceAndBusinessBean findPage(@Param("businessAccount")String businessAccount ){	
			
			ServiceAndBusinessBean bean =  serviceBusinessDemandServiceImpl.findOneServiceBusByBean(businessAccount);
			System.out.println(bean);
			return bean;
		}
}
