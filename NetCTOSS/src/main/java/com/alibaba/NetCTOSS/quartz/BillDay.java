package com.alibaba.NetCTOSS.quartz;

import javax.annotation.Resource;

import org.quartz.Job;
import org.quartz.JobExecutionContext;
import org.quartz.JobExecutionException;

import com.alibaba.NetCTOSS.activeMQ.producer.service.PushService;
import com.alibaba.NetCTOSS.activeMQ.producer.service.imp.NewPushService;

/**
 * 每日定时任务 当天的23：59：59触发 并保存为  日账务表
 * 
 * 每天的凌晨00：00：00开始包含
 * 到第二天00：00：00开始不包含
 * 
 * 新增今天 的日 账单    
 * 修改 月   账单明细
 * 
 * @author Administrator
 *
 */

public class BillDay implements Job {
	
	@Resource
	private PushService pushService;
	@Override
	public void execute(JobExecutionContext arg0) throws JobExecutionException {
		// TODO Auto-generated method stub
		
		pushService.push("开始每日工作！！");
	}
	
}
