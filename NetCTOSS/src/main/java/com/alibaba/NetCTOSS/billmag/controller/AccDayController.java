package com.alibaba.NetCTOSS.billmag.controller;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.annotation.Resource;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.alibaba.NetCTOSS.beans.billBean.AccountYearBillBean;
import com.alibaba.NetCTOSS.billmag.service_demand.IAccYearDemandService;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;

@RestController
@RequestMapping("/accDay")
public class AccDayController {
 
	@Resource
	private IAccYearDemandService iAccYearDemandService;
	
	@RequestMapping(value = "/findYear", method = { RequestMethod.GET })
	public Map<Object, Object> findAll(AccountYearBillBean accountYearBillBean,int page, int rows){
		Map<Object, Object> map = new HashMap<>();

		List<AccountYearBillBean> li = iAccYearDemandService.findAccountYearByBean(accountYearBillBean);
		
		PageHelper.startPage(page, rows);
		
		List<AccountYearBillBean> rolespage = iAccYearDemandService.findAccountYearByBean(accountYearBillBean);
		
		PageInfo<AccountYearBillBean> pages = new PageInfo<AccountYearBillBean>(rolespage);
		
		map.put("total", li.size());// 得到总条数
		map.put("rows", pages.getList());//得到每页的数据
		return map;
	}
}
