package com.alibaba.NetCTOSS.quartz;

import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Set;

import javax.annotation.Resource;

import org.quartz.Job;
import org.quartz.JobExecutionContext;
import org.quartz.JobExecutionException;

import com.alibaba.NetCTOSS.beans.billBean.AccountDayBean;
import com.alibaba.NetCTOSS.beans.billBean.AccountMonthBean;
import com.alibaba.NetCTOSS.billmag.service_demand.IAccDayDemandService;
import com.alibaba.NetCTOSS.billmag.service_handle.IAccMonthHandleService;
import com.alibaba.NetCTOSS.billmag.service_handle.IMonthAccHandleService;
import com.alibaba.NetCTOSS.billmag.service_handle.IMonthBusinessHandleService;
import com.alibaba.NetCTOSS.util.DateUtil;

/**
 * 每月定时任务 次月第一天 触发 并保存为  月账务表
 * 
 * 添加月志  
 * 将所有的 业务账户  的资费变为 下月的变为本月  并激活状态
 * 
 * 
 * 
 * @author Administrator
 *
 */
public class BillMonth implements Job {
	
	//得到 上月 的全部日志
	@Resource
	private IAccDayDemandService iAccDayDemandService;
	
	//创建新 的 月志
	@Resource
	private IAccMonthHandleService iAccMonthHandleService;

	
	@Override
	public void execute(JobExecutionContext arg0) throws JobExecutionException {
		// TODO Auto-generated method stub
		//得到当前时间
		Date date = DateUtil.getNewData("yyyy-MM-dd");
		String dates = date.toString();
				
		//当前时间进行拆分  得到 年 月 日
		String[] das = dates.split("-");
		int yea = Integer.valueOf( das[0]);
		int mont = Integer.valueOf(das[1]);
		int day = Integer.valueOf(das[2]);		
	
		AccountDayBean bean = new AccountDayBean();
		if(mont==1) {
			bean.setDay(day-1);
			bean.setMonth(mont-1);
		}else {
			bean.setMonth(mont-1);
			bean.setYear(yea);
		}
		
		List<AccountDayBean>  li = iAccDayDemandService.findAccountDayByBean(bean);
		
		Map<String,Object> map = new HashMap<>();
		for (AccountDayBean accountDayBean : li) {
			AccountMonthBean accountMonthBean = new AccountMonthBean();
			accountMonthBean.setMonth(mont-1);
			accountMonthBean.setYear(accountDayBean.getYear());
			accountMonthBean.setName(accountDayBean.getName());
			accountMonthBean.setTimeLong(accountDayBean.getTimeLong());
			accountMonthBean.setServer(accountDayBean.getServer());
			accountMonthBean.setOSAccount(accountDayBean.getOSAccount());
			if(map.get(accountDayBean.getAccount())==null) {
				map.put(accountDayBean.getAccount(), accountMonthBean);
			}else {
				AccountMonthBean accountMonthBean2 = (AccountMonthBean) map.get(accountDayBean.getAccount());
				accountMonthBean2.setTimeLong(accountMonthBean2.getTimeLong()+accountMonthBean.getTimeLong());
				map.put(accountDayBean.getAccount(), accountMonthBean2);
			}
			Set<String> set = map.keySet();
			for (String string : set) {
				AccountMonthBean amb = (AccountMonthBean)map.get(string);
				
				
				//加入消息队列  保存
				iAccMonthHandleService.saveAccountMonthBean(amb);
			}
		}
	}

}
