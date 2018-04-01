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

import com.alibaba.NetCTOSS.activeMQ.producer.service.PushService;
import com.alibaba.NetCTOSS.beans.billBean.AccountDayBean;
import com.alibaba.NetCTOSS.beans.billBean.AccountMonthBean;
import com.alibaba.NetCTOSS.billmag.service_demand.IAccDayDemandService;
import com.alibaba.NetCTOSS.billmag.service_handle.IAccMonthHandleService;
import com.alibaba.NetCTOSS.billmag.service_handle.IMonthAccHandleService;
import com.alibaba.NetCTOSS.billmag.service_handle.IMonthBusinessHandleService;
import com.alibaba.NetCTOSS.util.MyDateUtil;

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
	
	@Resource
	private PushService pushService;
	@Override
	public void execute(JobExecutionContext arg0) throws JobExecutionException {
		// TODO Auto-generated method stub
		
		pushService.push("开始每月工作！！");
	}
}
