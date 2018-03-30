package com.alibaba.NetCTOSS.billmag.controller;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.annotation.Resource;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.alibaba.NetCTOSS.beans.billBean.AccountMonthBean;
import com.alibaba.NetCTOSS.billmag.service_demand.IAccMonthDemandService;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;

@RestController
@RequestMapping("/accMonth")
public class AccMonthController {
	@Resource
	private IAccMonthDemandService iAccMonthDemandService;
	
	@RequestMapping(value = "/findMoth", method = { RequestMethod.GET })
	public Map<Object, Object> findAll(AccountMonthBean accountMonthBean,int page, int rows){
		Map<Object, Object> map = new HashMap<>();

		List<AccountMonthBean> li = iAccMonthDemandService.findAccountMonthByBean(accountMonthBean);
		
		PageHelper.startPage(page, rows);
		
		List<AccountMonthBean> rolespage = iAccMonthDemandService.findAccountMonthByBean(accountMonthBean);
		
		PageInfo<AccountMonthBean> pages = new PageInfo<AccountMonthBean>(rolespage);
		
		map.put("total", li.size());// 得到总条数
		map.put("rows", pages.getList());//得到每页的数据
		return map;
	}
}
