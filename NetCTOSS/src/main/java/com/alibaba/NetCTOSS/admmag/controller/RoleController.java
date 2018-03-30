package com.alibaba.NetCTOSS.admmag.controller;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.annotation.Resource;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.alibaba.NetCTOSS.admmag.service_demand.IRoleDemandService;
import com.alibaba.NetCTOSS.admmag.service_handle.IPowerHandleService;
import com.alibaba.NetCTOSS.admmag.service_handle.IRoleHandleService;
import com.alibaba.NetCTOSS.beans.admAndRoleBean.Messager;
import com.alibaba.NetCTOSS.beans.admAndRoleBean.PowerBean;
import com.alibaba.NetCTOSS.beans.admAndRoleBean.RoleBean;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;

@RequestMapping("/role")
@RestController
public class RoleController {

	@Resource
	private IRoleDemandService roleDemandServiceImpl;
	
	@Resource
	private IRoleHandleService roleHandleServiceImpl;

	@Resource
	private IPowerHandleService powerHandleService;

	@RequestMapping(value = "/findAllRoles", method = { RequestMethod.GET }, produces = {
			"application/json;charset=utf-8" })
	public Map<Object, Object> findAllPowerBean(int page, int rows, String roleName, String permission) {
		Map<Object, Object> map = new HashMap<>();

		Map<String, String> param = new HashMap<>();

		param.put("roleName", roleName);
		param.put("permission", permission);

		List<RoleBean> roles = roleDemandServiceImpl.findRolesByCondition(param);

		PageHelper.startPage(page, rows);

		List<RoleBean> rolespage = roleDemandServiceImpl.findRolesByCondition(param);

		PageInfo<RoleBean> pages = new PageInfo<RoleBean>(rolespage);

		map.put("total", roles.size());// 得到总条数
		map.put("rows", pages.getList());// 得到每页的数据
		return map;
	}

	@RequestMapping(value = "/save", method = { RequestMethod.POST }, 
			produces = { "application/json" })
	public Messager saveRole(RoleBean role,String items) {
		
		List<PowerBean> powers = new ArrayList<>();
		
		String[] powerName = items.split(",");
		for (String string : powerName) {
			PowerBean power = powerHandleService.findPowerBeanByPowerName(string);
			powers.add(power);
		}
		role.setStatus(1);
		role.setType("管理员");
		role.setPowers(powers);
		Messager mes = new Messager(1, "添加成功！");
		try {
			roleHandleServiceImpl.saveRole(role);
		} catch (Exception e) {
			// TODO: handle exception
			mes.setStatus(-1);
			mes.setInformation("添加失败！");
		}
		return mes;
	}
}