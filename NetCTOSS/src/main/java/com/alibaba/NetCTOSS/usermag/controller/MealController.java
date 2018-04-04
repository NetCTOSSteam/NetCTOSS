package com.alibaba.NetCTOSS.usermag.controller;

import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.ModelAndView;

import com.alibaba.NetCTOSS.beans.userAndBusBean.BusinessBean;
import com.alibaba.NetCTOSS.beans.userAndBusBean.MealBean;
import com.alibaba.NetCTOSS.usermag.service_demand.IBusinessDemandService;
import com.alibaba.NetCTOSS.usermag.service_demand.IMealDemandService;
import com.alibaba.NetCTOSS.usermag.service_handle.IMealHandleService;
import com.alibaba.fastjson.JSONObject;

import com.github.pagehelper.PageInfo;


@RequestMapping("/tar")
@RestController
public class MealController {
	private static final String JSONSerializer = null;
	@Resource
	private IMealDemandService mealDemandServiceImpl;
	@Resource
	private IMealHandleService mealHandleServiceImpl;
	@Resource
	IBusinessDemandService businessDemandServiceImpl;
	/**
	 * 首页分页显示
	 * @param mv
	 * @param page 第几页
	 * @param pageSize  多少行
	 * @return ModelAndView
	 */
	@RequestMapping(value = "/all", method = { RequestMethod.GET }, produces = {  "application/json;charset=utf-8" })
	public String findPage(HttpServletRequest request
		){
		    String dang_qian_ye_ma = request.getParameter("page");//page 为easyui分页插件默认传到后台的参数，代表当前的页码，起始页为1  
		    String mei_ye_ji_lu_shu = request.getParameter("rows");//rows为为easyui分页插件默认传到后台的参数，代表当前设置的每页显示的记录条数 
			int page=Integer.parseInt(dang_qian_ye_ma);
			int pageSize=Integer.parseInt(mei_ye_ji_lu_shu);
		 
		  List<MealBean> list=mealDemandServiceImpl.findAllMealBean(page,pageSize);
	     PageInfo<MealBean> pageInfo=new PageInfo<MealBean>(list);
		  long total = pageInfo.getTotal(); //获取总记录数  
		  
		  Map<String, Object> jsonMap = new HashMap<String, Object>();//定义map   
		  
          jsonMap.put("total", total);//total 存放总记录数  
          jsonMap.put("rows", list);//rows存放每页记录 ，这里的两个参数名是固定的，必须为 total和 rows  
         
         //转换
          
          JSONObject json = new JSONObject(jsonMap);
         
          String jsonString = json.toJSONString();
   
		 return jsonString;  
	} 
	
	@RequestMapping(value = "/adds", method = { RequestMethod.POST }, produces = { "application/json;charset=utf-8" })
	public boolean savaMealBean(MealBean bean) {
		
		System.out.println(bean);
		try {
		
			mealHandleServiceImpl.addMealBean(bean);
		
			System.out.println(	bean.getMealStartTime());
			return true;
			
		} catch (Exception e) {
			// TODO: handle exception			
			  System.out.println("有误");
	}	
		return false;
	}	
	
	@RequestMapping(value="/{mealId}",method= {RequestMethod.DELETE},produces= {"application/json;charset=utf-8"})
	public void delectMealBean(MealBean bean ) {
		System.out.println( bean.getMealId());
		
		mealHandleServiceImpl.deletedByMealBeanID(bean.getMealId());	
	}
	@RequestMapping(value="/update",method= {RequestMethod.PUT},produces= {"application/json;charset=utf-8"})
	public boolean updeteMealBean(MealBean bean) {
		System.out.println(bean);
		try {
	
			mealHandleServiceImpl.updateMealBean(bean);	
			return true;
		 	
		} catch (Exception e) {
			// TODO: handle exception			
	}	
		return false;
			
	}
	@RequestMapping(value = "/name", method = { RequestMethod.GET }, produces = { "application/json" })
	public String findByMealBeanName(String name) {
	
		  List<String> list=mealDemandServiceImpl.findByfindByMealBeanName(name);
		 if(list.size()!=0) {
				return "no";
		 }
		return null;
	}	
	
	@RequestMapping(value="/update1",method= {RequestMethod.PUT},produces= {"application/json;charset=utf-8"})
	public boolean updeteMealBean1(MealBean bean) {
		System.out.println(bean);
		try {
	          bean.setMealStatus(true);
	          bean.setMealStartTime(new Date());
			mealHandleServiceImpl.updateMealBean(bean);	
			return true;
			
		} catch (Exception e) {
			// TODO: handle exception			
	}	
		return false;
			
	}
	@RequestMapping(value="/update2",method= {RequestMethod.PUT},produces= {"application/json;charset=utf-8"})
	public boolean updeteMealBean2(MealBean bean) {
		
		BusinessBean bus=new BusinessBean();
	  List<BusinessBean> lsit=businessDemandServiceImpl.findLikeByBean(bus);
	  
	      for (BusinessBean businessBean : lsit) {
	  
		      if(businessBean.getNextMealBean().getMealId()==bean.getMealId()) {
			return false;
			
		}else {
			
		          bean.setMealStatus(false);
		          bean.setMealStartTime(new Date());
				mealHandleServiceImpl.updateMealBean(bean);	
				return true;
				
			 
		}
	}
			
		return false;
			
	}	
	@RequestMapping(value = "/allname", method = { RequestMethod.POST }, produces = { "application/json" })
	public List<Map> findName(){
		
		List<Map> li  = new ArrayList<>();
 		
		List<MealBean> list=mealDemandServiceImpl.findAllMealBean1();
	
		//转换
		for (MealBean mealBean : list) {
		Map map = new HashMap<>();
			map.put("id", mealBean.getMealName());
			map.put("text", mealBean.getMealName());
			li.add(map);
		}
		
		return  li;
	} 
}
