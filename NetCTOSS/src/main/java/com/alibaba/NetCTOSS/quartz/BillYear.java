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

import com.alibaba.NetCTOSS.beans.billBean.AccountMonthBean;
import com.alibaba.NetCTOSS.beans.billBean.AccountYearBillBean;
import com.alibaba.NetCTOSS.beans.userAndBusBean.UserBean;
import com.alibaba.NetCTOSS.billmag.service_demand.IAccMonthDemandService;
import com.alibaba.NetCTOSS.billmag.service_handle.IAccYearHandleService;
import com.alibaba.NetCTOSS.usermag.service_demand.IUserDemandService;
import com.alibaba.NetCTOSS.util.DateUtil;

/**
 * 每年定时任务 每年第最后月的最后一天的23：59：59触发 并保存为  年账务表
 * 
 * 
 * 
 * @author Administrator
 *
 */
public class BillYear implements Job {

	//得到 上月 的全部日志
		@Resource
		private IAccMonthDemandService iAccMonthDemandService;
		
		//创建新 的 月志
		@Resource
		private IAccYearHandleService iAccYearHandleService;

		@Resource
		private IUserDemandService iUserDemandService;
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
		
		AccountMonthBean bean = new AccountMonthBean();
		
		if(mont==1) {
			bean.setYear(yea-1);
		}else {
			bean.setYear(yea);
		}
		List<AccountMonthBean>  li = iAccMonthDemandService.findAccountMonthByBean(bean);
		Map<String,Object> map = new HashMap<String,Object>();
		for (AccountMonthBean accountMonthBean : li) {
			AccountYearBillBean accountYearBillBean = new AccountYearBillBean();
			
			if(map.get(accountMonthBean.getAccount()) == null) {
				accountYearBillBean.setAccount(accountMonthBean.getAccount());
				UserBean  user =  new UserBean();
				user.setUserName(accountMonthBean.getAccount());
				user  = iUserDemandService.findByBean(user);
				accountYearBillBean.setBusNum(user.getBusinessBeans().size());
				accountYearBillBean.setTimeLong(accountMonthBean.getTimeLong());
				accountYearBillBean.setYear(yea);
			}else {
				AccountYearBillBean accountYearBillBean2 =  (AccountYearBillBean) map.get(accountMonthBean.getAccount());
				accountYearBillBean2.setTimeLong(accountYearBillBean2.getTimeLong()+accountMonthBean.getTimeLong());
				
			}
			
		}
		Set<String> set = map.keySet();
		for (String string : set) {
			iAccYearHandleService.saveAccountYearBean((AccountYearBillBean) map.get(string));
		}
	}

}
