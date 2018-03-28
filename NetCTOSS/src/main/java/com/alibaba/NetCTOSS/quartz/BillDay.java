package com.alibaba.NetCTOSS.quartz;

import java.util.Date;

import javax.annotation.Resource;

import org.quartz.Job;
import org.quartz.JobExecutionContext;
import org.quartz.JobExecutionException;

import com.alibaba.NetCTOSS.billmag.service_demand.IServiceBusinessDemandService;
import com.alibaba.NetCTOSS.billmag.service_handle.IAccDayHandleService;
import com.alibaba.NetCTOSS.billmag.service_handle.IAccMonthHandleService;
import com.alibaba.NetCTOSS.billmag.service_handle.IAccYearHandleService;
import com.alibaba.NetCTOSS.util.DateUtil;

/**
 * 每日定时任务 当天的23：59：59触发 并保存为  日账务表
 * 
 * 每天的凌晨00：00：00开始包含
 * 到第二天00：00：00开始不包含
 * 
 * 新增今天 的日 账单    修改 月年 的 账单
 * 
 * @author Administrator
 *
 */
public class BillDay implements Job {

	@Resource
	private IServiceBusinessDemandService  iServiceBusinessDemandService;
	@Resource
	private IAccDayHandleService iAccDayHandleService;
	@Resource
	private IAccMonthHandleService iAccMonthHandleService;
	@Resource
	private IAccYearHandleService iAccYearHandleService;
	
	
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
		
		
		
	}

}
