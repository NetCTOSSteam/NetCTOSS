package com.alibaba.NetCTOSS.admmag.controller;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Set;

import javax.annotation.Resource;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.alibaba.NetCTOSS.admmag.service_demand.IRoleDemandService;
import com.alibaba.NetCTOSS.beans.admAndRoleBean.RoleBean;
import com.github.pagehelper.Page;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;

@RestController
@RequestMapping("/role")
public class RoleController {

	@Resource
	private IRoleDemandService roleDemandServiceImpl;

	@RequestMapping(value = "/findAllRoles", method = { RequestMethod.GET }, produces = {
			"application/json;charset=utf-8" })
	public Map<Object, Object> findAllPowerBean(int page, int rows) {
		Map<Object, Object> map = new HashMap<>();

		List<RoleBean> roles = roleDemandServiceImpl.findAllRoles();
		
		PageHelper.startPage(page, rows);
		
		List<RoleBean> rolespage = roleDemandServiceImpl.findAllRoles();
		
		PageInfo<RoleBean> pages = new PageInfo<RoleBean>(rolespage);
		
		map.put("total", roles.size());// 得到总条数
		map.put("rows", pages.getList());//得到每页的数据
		return map;
	}
}
