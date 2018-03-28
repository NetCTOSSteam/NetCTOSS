package com.alibaba.NetCTOSS.quartz;

import org.quartz.Job;
import org.quartz.JobExecutionContext;
import org.quartz.JobExecutionException;

/**
 * 每年定时任务 每年第最后月的最后一天的23：59：59触发 并保存为  年账务表
 * 
 * 
 * 
 * @author Administrator
 *
 */
public class BillYear implements Job {

	@Override
	public void execute(JobExecutionContext arg0) throws JobExecutionException {
		// TODO Auto-generated method stub
		System.err.println("运行年账单");
	}

}
