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
import com.alibaba.NetCTOSS.beans.billBean.AccountMonthBean;
import com.alibaba.NetCTOSS.beans.billBean.AccountYearBillBean;
import com.alibaba.NetCTOSS.beans.userAndBusBean.UserBean;
import com.alibaba.NetCTOSS.billmag.service_demand.IAccMonthDemandService;
import com.alibaba.NetCTOSS.billmag.service_handle.IAccYearHandleService;
import com.alibaba.NetCTOSS.usermag.service_demand.IUserDemandService;
import com.alibaba.NetCTOSS.util.MyDateUtil;

/**
 * 每年定时任务 每年第最后月的最后一天的23：59：59触发 并保存为  年账务表
 * 
 * 
 * 
 * @author Administrator
 *
 */
public class BillYear implements Job {

	@Resource
	private PushService pushService;
	@Override
	public void execute(JobExecutionContext arg0) throws JobExecutionException {
		// TODO Auto-generated method stub
		
		pushService.push("开始每年工作！！");
	}
}
