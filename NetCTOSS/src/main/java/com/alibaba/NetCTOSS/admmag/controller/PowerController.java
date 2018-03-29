package com.alibaba.NetCTOSS.admmag.controller;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Set;

import javax.annotation.Resource;

import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.alibaba.NetCTOSS.admmag.service_demand.IPowerDemandService;
import com.alibaba.NetCTOSS.beans.admAndRoleBean.PowerBean;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;

@RestController
@RequestMapping("/power")
public class PowerController {
	
	@Resource
	private IPowerDemandService powerDemandServiceImpl;
	
	
	@RequestMapping(value = "/findAll", method = { RequestMethod.GET }, produces = { "application/json;charset=utf-8" })
	public Map<Object, Object> findAllPowerBean(int page,int rows) {
		Map<Object, Object> map = new HashMap<>();
		
		PageHelper.startPage(page, rows);
		
		Set<PowerBean> powers =  powerDemandServiceImpl.findAllPowers();
		
		PageInfo<PowerBean> pages = new PageInfo<PowerBean>((List<PowerBean>) powers);
		
		map.put("total", pages.getTotal());//得到总条数
		map.put("rows", pages.getPageNum());//当前是第几页
		
		return map;
	}
}
