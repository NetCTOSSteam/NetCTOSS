package com.alibaba.NetCTOSS.billmag.controller;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.annotation.Resource;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.alibaba.NetCTOSS.beans.billBean.MonthAndAccountBean;
import com.alibaba.NetCTOSS.billmag.service_demand.IMonthAccDemandService;
import com.alibaba.NetCTOSS.billmag.service_handle.IMonthAccHandleService;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;

@RestController
@RequestMapping("/monthAcc")
public class MonthAccController {
 
	@Resource
	private IMonthAccDemandService monthAccDemandServiceimpl;
	@Resource
	private IMonthAccHandleService monthAccHandleServiceImpl;
	/**
	 * 首页分页显示
	 * @param mv
	 * @param page 第几页
	 * @param pageSize  多少行
	 * @return ModelAndView
	 */
	@RequestMapping(value = "/all", method = { RequestMethod.GET }, produces = { "application/json" })
	public Map findPage(int page, int rows, MonthAndAccountBean bean){	
		Map<Object, Object> map = new HashMap<>();
		System.out.println(bean);
		 List<MonthAndAccountBean>  dataAll = monthAccDemandServiceimpl.findLikeMonthAndAccountBean(bean);
		System.out.println(dataAll);
		 PageHelper.startPage(page, rows);
		  List<MonthAndAccountBean>  data = monthAccDemandServiceimpl.findLikeMonthAndAccountBean(bean);
		System.out.println(data);
		  PageInfo<MonthAndAccountBean> pageInfo =new PageInfo<MonthAndAccountBean>(data);
		
			map.put("total", dataAll.size());// 得到总条数
			map.put("rows", pageInfo.getList());//得到数据
			
			return map;

	}
	

	
	@RequestMapping(value = "/check", method = { RequestMethod.PUT }, produces = { "application/json" })
	public String updateMonthAndAccountBean(MonthAndAccountBean bean ) {
		
		
		try {
			bean.setStatus(1);
			monthAccHandleServiceImpl.updateMonthAndAccountBean(bean);
			return "ok";
			
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		}
		
		return "false";
	}
	
}
