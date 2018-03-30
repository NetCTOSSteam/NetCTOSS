package com.alibaba.NetCTOSS.logmag.controller;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Set;

import javax.annotation.Resource;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.alibaba.NetCTOSS.beans.admAndRoleBean.PowerBean;
import com.alibaba.NetCTOSS.beans.logBean.DoLogBean;
import com.alibaba.NetCTOSS.logmag.service_demand.IDoLogDemandService;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;

@RestController
@RequestMapping("/doLog")
public class DoLogController {
	
	@Resource
	private IDoLogDemandService doLogDemandServiceImpl;
	
	@RequestMapping(value = "/findAll", method = { RequestMethod.GET }, produces = { "application/json;charset=utf-8" })
	public Map<Object, Object> findAll(int page,int rows) {
		Map<Object, Object> map = new HashMap<>();
		
		PageHelper.startPage(page, rows);
		
		Set<DoLogBean> doLog =  doLogDemandServiceImpl.findAll();
		
		PageInfo<DoLogBean> pages = new PageInfo<DoLogBean>((List<DoLogBean>) doLog);
		
		map.put("total", pages.getTotal());//得到总条数
		map.put("rows", pages.getPageNum());//当前是第几页
		
		return map;
	}
}
