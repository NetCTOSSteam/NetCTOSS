package com.alibaba.NetCTOSS.quartz;

import org.quartz.Job;
import org.quartz.JobExecutionContext;
import org.quartz.JobExecutionException;

/**
 * 每日定时任务 当天的23：59：59触发 并保存为  日账务表
 * 
 * 每天的凌晨00：00：00开始包含
 * 到第二天00：00：00开始不包含
 * 
 * @author Administrator
 *
 */
public class BillDay implements Job {

	@Override
	public void execute(JobExecutionContext arg0) throws JobExecutionException {
		// TODO Auto-generated method stub

		
		
		
		
	}

}
