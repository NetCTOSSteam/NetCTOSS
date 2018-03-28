package com.alibaba.NetCTOSS.quartz;

import org.quartz.Job;
import org.quartz.JobExecutionContext;
import org.quartz.JobExecutionException;

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

	@Override
	public void execute(JobExecutionContext arg0) throws JobExecutionException {
		// TODO Auto-generated method stub
		System.err.println("运行月账单");
	}

}
