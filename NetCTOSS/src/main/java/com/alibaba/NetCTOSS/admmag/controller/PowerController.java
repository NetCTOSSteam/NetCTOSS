package com.alibaba.NetCTOSS.admmag.controller;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.annotation.Resource;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.alibaba.NetCTOSS.admmag.service_demand.IPowerDemandService;
import com.alibaba.NetCTOSS.admmag.service_handle.IPowerHandleService;
import com.alibaba.NetCTOSS.beans.admAndRoleBean.Messager;
import com.alibaba.NetCTOSS.beans.admAndRoleBean.PowerBean;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;

@RestController
@RequestMapping("/power")
public class PowerController {

	@Resource
	private IPowerDemandService powerDemandServiceImpl;
	@Resource
	private IPowerHandleService powerHandleServiceImpl;

	@RequestMapping(value = "/findAllPowers", method = { RequestMethod.GET }, produces = {
			"application/json;charset=utf-8" })
	public List<PowerBean> findAllPowerBean() {

		List<PowerBean> list = powerDemandServiceImpl.findAllPowers();

		return list;
	}

	@RequestMapping(value = "/findPowers", method = { RequestMethod.GET }, produces = {
			"application/json;charset=utf-8" })
	public Map<Object, Object> findAllPowerBean(int page, int rows, String powerName) {
		Map<Object, Object> map = new HashMap<>();

		Map<String, String> param = new HashMap<>();

		param.put("powerName", powerName);

		List<PowerBean> roles = powerDemandServiceImpl.findPowersByCondition(param);

		PageHelper.startPage(page, rows);

		List<PowerBean> rolespage = powerDemandServiceImpl.findPowersByCondition(param);

		PageInfo<PowerBean> pages = new PageInfo<PowerBean>(rolespage);

		map.put("total", roles.size());// 得到总条数
		map.put("rows", pages.getList());// 得到每页的数据
		return map;
	}
	
	
	@RequestMapping(value = "/save", method = { RequestMethod.POST }, 
			produces = { "application/json" })
	public Messager savePower(PowerBean power) {
		
		power.setStatus(1);
		
		Messager mes = new Messager(1, "添加成功！");
		try {
			powerHandleServiceImpl.savePowerBean(power);
		} catch (Exception e) {
			// TODO: handle exception
			mes.setStatus(-1);
			mes.setInformation("添加失败！");
		}
		return mes;
	}
	
	@RequestMapping(value = "/{id}", method = { RequestMethod.PUT }, 
			produces = { "application/json" })
	public Messager updatePower(PowerBean power) {
		
		power.setStatus(1);
		Messager mes = new Messager(1, "修改成功！");
		try {
			powerHandleServiceImpl.savePowerBean(power);
		} catch (Exception e) {
			// TODO: handle exception
			mes.setStatus(-1);
			mes.setInformation("修改失败！");
		}
		return mes;
	}
	
	
	@RequestMapping(value = "/delete/{id}", method = { RequestMethod.PUT }, 
			produces = { "application/json" })
	public Messager deletePower(PowerBean power) {
		
		power.setStatus(0);
		
		Messager mes = new Messager(1, "删除成功！");
		try {
			powerHandleServiceImpl.deletePowerBean(power);
		} catch (Exception e) {
			// TODO: handle exception
			mes.setStatus(-1);
			mes.setInformation("删除失败！");
		}
		return mes;
	}
}
