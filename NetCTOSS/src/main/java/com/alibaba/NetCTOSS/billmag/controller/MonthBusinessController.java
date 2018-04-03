package com.alibaba.NetCTOSS.billmag.controller;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.annotation.Resource;

import org.springframework.data.repository.query.Param;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.alibaba.NetCTOSS.beans.billBean.MonthAndBusinessBean;
import com.alibaba.NetCTOSS.billmag.service_demand.IMonthBusinessDemandService;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;

@RestController
@RequestMapping("/monthBusiness")
public class MonthBusinessController {

	 
	@Resource
	private IMonthBusinessDemandService  monthBusinessDemandServiceImpl;
	/**
	 * 首页分页显示
	 * @param mv
	 * @param page 第几页
	 * @param pageSize  多少行
	 * @return ModelAndView
	 */
	@RequestMapping(value = "/all", method = { RequestMethod.GET }, produces = { "application/json" })
	public Map findPage(int page, int rows,@Param("account")String account ){	
		Map<Object, Object> map = new HashMap<>();
		
		 List<MonthAndBusinessBean>  dataAll = monthBusinessDemandServiceImpl.findByServerMothAndBusinessBean(account);
		PageHelper.startPage(page, rows);
		  List<MonthAndBusinessBean>  data = monthBusinessDemandServiceImpl.findByServerMothAndBusinessBean(account);
		System.out.println(data);
		  PageInfo<MonthAndBusinessBean> pageInfo =new PageInfo<MonthAndBusinessBean>(data);
		
			map.put("total", dataAll.size());// 得到总条数
			map.put("rows", pageInfo.getList());//得到数据
			
			return map;

	}
	
	
	@RequestMapping(value = "/likeAll", method = { RequestMethod.GET }, produces = { "application/json" })
	public Map findPage(int page, int rows,MonthAndBusinessBean bean ){	
		Map<Object, Object> map = new HashMap<>();
		
		List<MonthAndBusinessBean>   dataAll = monthBusinessDemandServiceImpl.findLikeMonthAndBusinessBean(bean);
		PageHelper.startPage(page, rows);
		  List<MonthAndBusinessBean>  data = monthBusinessDemandServiceImpl.findLikeMonthAndBusinessBean(bean);
		System.out.println(data);
		  PageInfo<MonthAndBusinessBean> pageInfo =new PageInfo<MonthAndBusinessBean>(data);
		
			map.put("total", dataAll.size());// 得到总条数
			map.put("rows", pageInfo.getList());//得到数据
			
			return map;

	}
	
	/**
	 * 查询所有资费类型的名字的方法
	 * @return
	 */
	@RequestMapping(value = "/tariff", method = { RequestMethod.GET }, produces = { "application/json" })
	public List<Map> findByServerMothAndBusinessBeanAllTariff(@Param("tariff")String tariff ){	
		
		
		List<MonthAndBusinessBean> data = monthBusinessDemandServiceImpl.findByServerMothAndBusinessBeanAllTariff();
		List <Map> li = new ArrayList<>();
		for (MonthAndBusinessBean monthAndBusinessBean : data) {
			Map map = new HashMap<>();
			map.put("id", monthAndBusinessBean.getTariff());
			map.put("tariff", monthAndBusinessBean.getTariff());
			li.add(map);
		}
		
		
		return li;
	}	
	
	@RequestMapping(value = "/findByYearAndAcc", method = { RequestMethod.GET }, produces = { "application/json" })
	public List<MonthAndBusinessBean> findByYearAndAcc(String account,int year){
		
		
		return monthBusinessDemandServiceImpl.findAllMonthBussinessByAccAndYear(account, year);
		
	}
}
