package com.alibaba.NetCTOSS.usermag.controller;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.annotation.Resource;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.alibaba.NetCTOSS.beans.userAndBusBean.BusinessBean;
import com.alibaba.NetCTOSS.usermag.service_demand.IBusinessDemandService;
import com.alibaba.NetCTOSS.usermag.service_handle.IBusinessHandleService;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;

@RestController
@RequestMapping("/busi")
public class BusinessController {
	
	@Resource
	private IBusinessDemandService iBusinessDemandService;
	@Resource
	private IBusinessHandleService iBusinessHandleService;
	
	@RequestMapping(value = "/find", method = { RequestMethod.GET },produces = { "application/json" })
	public Map<Object, Object> likeFindAll(BusinessBean businessBean,Integer page, Integer rows) {
		Map<Object, Object> map = new HashMap<>();
		
		List<BusinessBean> li = iBusinessDemandService.findLikeByBean(businessBean);
		
		PageHelper.startPage(page, rows);
		
		List<BusinessBean> lis = iBusinessDemandService.findLikeByBean(businessBean);
		
		PageInfo<BusinessBean> pages = new PageInfo<BusinessBean>(lis);
		
		map.put("total", li.size());// 得到总条数
		map.put("rows", pages.getList());//得到每页的数据
		
		return map;
	}
	
	@RequestMapping(value = "/findone", method = { RequestMethod.GET },produces = { "application/json" })
	public BusinessBean findOne (BusinessBean businessBean) {
		BusinessBean bean = iBusinessDemandService.findByBean(businessBean);
		return bean;
	}
	
	@RequestMapping(value = "/updateone", method = { RequestMethod.PUT })
	public void updaeOne(BusinessBean businessBean) {
		iBusinessHandleService.updateBusinessBean(businessBean);
	}
	@RequestMapping(value = "/updatSata", method = { RequestMethod.PUT })
	public void updaeStat(BusinessBean businessBean) {
		
		businessBean = iBusinessDemandService.findByBean(businessBean);
		businessBean.setState("开通");
		
		iBusinessHandleService.updateBusinessBean(businessBean);
	}
	@RequestMapping(value = "/delete", method = { RequestMethod.DELETE })
	public void updaeDelete(BusinessBean businessBean) {
		
		businessBean = iBusinessDemandService.findByBean(businessBean);
		businessBean.setBo(0);
		
		iBusinessHandleService.updateBusinessBean(businessBean);
	}
	
	@RequestMapping(value = "/deleteone", method = { RequestMethod.DELETE })
	public void deleteOne(BusinessBean businessBean) {
		iBusinessHandleService.updateBusinessBean(businessBean);
	}
	@RequestMapping(value = "/addone", method = { RequestMethod.POST })
	public void addOne(BusinessBean businessBean) {
		iBusinessHandleService.saveBusinessBean(businessBean);
	}
	
}
