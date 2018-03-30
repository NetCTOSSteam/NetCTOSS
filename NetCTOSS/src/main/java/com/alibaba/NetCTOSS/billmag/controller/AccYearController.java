package com.alibaba.NetCTOSS.billmag.controller;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.annotation.Resource;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.alibaba.NetCTOSS.beans.billBean.AccountDayBean;
import com.alibaba.NetCTOSS.billmag.service_demand.IAccDayDemandService;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;

@RestController
@RequestMapping("/accYear")
public class AccYearController {
 
	@Resource
	private IAccDayDemandService iAccDayDemandService;
	
	@RequestMapping(value = "/findMoth", method = { RequestMethod.GET })
	public Map<Object, Object> findAll(AccountDayBean accountDayBean,int page, int rows){
		Map<Object, Object> map = new HashMap<>();

		List<AccountDayBean> li = iAccDayDemandService.findAccountDayByBean(accountDayBean);
		
		PageHelper.startPage(page, rows);
		
		List<AccountDayBean> rolespage = iAccDayDemandService.findAccountDayByBean(accountDayBean);
		
		PageInfo<AccountDayBean> pages = new PageInfo<AccountDayBean>(rolespage);
		
		map.put("total", li.size());// 得到总条数
		map.put("rows", pages.getList());//得到每页的数据
		return map;
	}
}
