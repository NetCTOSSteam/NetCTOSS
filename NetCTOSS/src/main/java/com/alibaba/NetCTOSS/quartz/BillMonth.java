package com.alibaba.NetCTOSS.quartz;

import org.quartz.Job;
import org.quartz.JobExecutionContext;
import org.quartz.JobExecutionException;

/**
 * 每月定时任务 当月最后一天的23：59：59触发 并保存为  日账务表
 * 
 * 月初当天的凌晨00：00：00开始包含
 * 下月第一天00：00：00开始不包含
 * 
 * @author Administrator
 *
 */
public class BillMonth implements Job {

	@Override
	public void execute(JobExecutionContext arg0) throws JobExecutionException {
		// TODO Auto-generated method stub

	}

}
