package com.alibaba.NetCTOSS.admmag.controller;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.alibaba.NetCTOSS.admmag.service_demand.IPowerDemandService;
import com.alibaba.NetCTOSS.beans.admAndRoleBean.PowerBean;

@RestController
@RequestMapping("/power")
public class PowerController {
	
	@Resource
	private IPowerDemandService powerDemandServiceImpl;
	
	
	@RequestMapping(value = "/findAllPowers", method = { RequestMethod.GET }, produces = { "application/json;charset=utf-8" })
	public List<PowerBean> findAllPowerBean() {
		
		List<PowerBean> list =  powerDemandServiceImpl.findAllPowers();
		
		return list;
	}
}
