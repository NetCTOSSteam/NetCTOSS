package com.alibaba.NetCTOSS.quartz;

import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.annotation.Resource;

import org.quartz.Job;
import org.quartz.JobExecutionContext;
import org.quartz.JobExecutionException;

import com.alibaba.NetCTOSS.activeMQ.service.PushService;
import com.alibaba.NetCTOSS.activeMQ.service.imp.NewPushService;
import com.alibaba.NetCTOSS.beans.billBean.AccountDayBean;
import com.alibaba.NetCTOSS.beans.billBean.MonthAndAccountBean;
import com.alibaba.NetCTOSS.beans.billBean.MonthAndBusinessBean;
import com.alibaba.NetCTOSS.beans.billBean.ServiceAndBusinessBean;
import com.alibaba.NetCTOSS.beans.userAndBusBean.BusinessBean;
import com.alibaba.NetCTOSS.beans.userAndBusBean.MealBean;
import com.alibaba.NetCTOSS.beans.userAndBusBean.UserBean;
import com.alibaba.NetCTOSS.billmag.service_demand.IAccDayDemandService;
import com.alibaba.NetCTOSS.billmag.service_demand.IMonthAccDemandService;
import com.alibaba.NetCTOSS.billmag.service_demand.IMonthBusinessDemandService;
import com.alibaba.NetCTOSS.billmag.service_demand.IServiceBusinessDemandService;
import com.alibaba.NetCTOSS.billmag.service_handle.IAccDayHandleService;
import com.alibaba.NetCTOSS.billmag.service_handle.IMonthAccHandleService;
import com.alibaba.NetCTOSS.billmag.service_handle.IMonthBusinessHandleService;
import com.alibaba.NetCTOSS.usermag.service_demand.IBusinessDemandService;
import com.alibaba.NetCTOSS.usermag.service_demand.IUserDemandService;
import com.alibaba.NetCTOSS.util.DateUtil;

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
	private IServiceBusinessDemandService  iServiceBusinessDemandService;
	
	@Resource
	private IAccDayHandleService IAccDayHandleService;
	@Resource
	private IAccDayDemandService iAccDayDemandService;
	
	@Resource
	private IUserDemandService iUserDemandService;
	@Resource
	private IBusinessDemandService iBusinessDemandService;
	
	@Resource
	private IMonthAccDemandService iMonthAccDemandService;
	@Resource
	private IMonthAccHandleService iMonthAccHandleService;
	
	@Resource
	private IMonthBusinessDemandService iMonthBusinessDemandService;
	@Resource
	private IMonthBusinessHandleService iMonthBusinessHandleService;
	
	@Resource
    private PushService userPushService;
	
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
		
		//查询出当天的 服务器使用 记录
		ServiceAndBusinessBean bean = new ServiceAndBusinessBean();
		bean.setStartTime(date);
		
		List<ServiceAndBusinessBean> li = iServiceBusinessDemandService.findServiceBusByBean(bean);
		Map map1 = new HashMap<>();
		map1.put("1", "可以了！！！！！");
		userPushService.push(map1);
		//此时调用消息列队
		for (ServiceAndBusinessBean serviceAndBusinessBean : li) {
			AccountDayBean accountDayBean = saveAccDayBill(serviceAndBusinessBean,yea,mont,day);
			
			MonthAndBusinessBean monthAndBusinessBean = updateMonthBus(serviceAndBusinessBean,yea,mont,day);
			double  money = monthAndBusinessBean.getMoney();
			MonthAndAccountBean monthAndAccountBean = updateMonthAcc(serviceAndBusinessBean,yea,mont,day,money);
			
//			NewPushService newPushService = new NewPushService();
			Map map = new HashMap<>();
			
			/*
			 * day
			 * month
			 * year
			 * mbus
			 * macc
			 */
			map.put("day", accountDayBean);
			map.put("mbus", monthAndBusinessBean);
			map.put("macc", monthAndAccountBean);
//			newPushService.push(map);
		}
	}
	
	/**
	 * 添加每天的 日志
	 */
	private AccountDayBean saveAccDayBill(ServiceAndBusinessBean bean,int y ,int m , int d) {
		
		UserBean user = new UserBean();
		BusinessBean bus = new BusinessBean();
		
		//根据得到的IP   查询得到对应的业务账户对象 
		bus.setServerIP(bean.getServerIP());
		bus = iBusinessDemandService.findByBean(bus);
		
		//得到对应 的账务对象 
		AccountDayBean accountDayBean = new AccountDayBean();
		user = bus.getUserBean();
		accountDayBean.setDay(d);
		accountDayBean.setYear(y);
		accountDayBean.setMonth(m);
		accountDayBean.setOSAccount(bean.getOSAccount());
		accountDayBean.setAccount(user.getLoginName());
		accountDayBean.setName(user.getUserName());
		accountDayBean.setServer(bus.getServerIP());
		accountDayBean.setTimeLong((int)bean.getOnlineTimr());
		
		IAccDayHandleService.saveAccountDayBean(accountDayBean);
		//保存当天的  日志
		return accountDayBean;
	}

	/**
	 * 修改当月的 该账务账户  账单
	 */
	private MonthAndAccountBean updateMonthAcc(ServiceAndBusinessBean bean,int y ,int m , int d,double money) {
		UserBean user = new UserBean();
		BusinessBean bus = new BusinessBean();
		MealBean mealBean = new MealBean();
		
		//根据得到的IP   查询得到对应的业务账户对象 
		bus.setServerIP(bean.getServerIP());
		bus = iBusinessDemandService.findByBean(bus);
		
		//得到对应 的账务对象  资费对象
		user = bus.getUserBean();
		mealBean = bus.getMealBean();
		
		//构造对象  查询出 账务月账单  明细 
		MonthAndAccountBean maab = new MonthAndAccountBean();
		maab.setAccount(user.getLoginName());
		maab.setMonth(m);
		maab.setYear(y);
		
		if(iMonthAccDemandService.findByMonthAndAccountBean(maab) == null) {
			maab.setIDcard(user.getIdCard());
			maab.setName(user.getUserName());
			maab.setStatus(1);
		}else{
			maab = iMonthAccDemandService.findByMonthAndAccountBean(maab);
		}
		
		
		switch (mealBean.getMealType()) {
		case 1:
		System.out.println("暂时不清楚 123 对应那种类型 的资费");	
	/*
	 * 	包月 
	 * 
	 * 套餐 不设置 money
	 * 
	 * maab.setType(bus.getNextMealBean().getMealName());
			
		maab.setMoney(0);
	 * 
	 * 按时就直接 加
	 */
		
		
			break;
		case 2:
			
			break;
		case 3:
			
			break;

		default:
			System.err.println("异常！！！没有资费类型");
			break;
		}
		
		iMonthAccHandleService.saveMonthAndAccountBean(maab);
		return maab;
	}
	/**
	 * 修改当月 每一个业务账户的 账单
	 */
	private MonthAndBusinessBean updateMonthBus(ServiceAndBusinessBean bean,int y ,int m , int d) {
		
		UserBean user = new UserBean();
		BusinessBean bus = new BusinessBean();
		MealBean mealBean = new MealBean();
		
		//根据得到的IP   查询得到对应的业务账户对象 
		bus.setServerIP(bean.getServerIP());
		bus = iBusinessDemandService.findByBean(bus);
		
		//得到对应 的账务对象  资费对象
		user = bus.getUserBean();
		mealBean = bus.getMealBean();
		
		//构造对象  查询出 业务月账单  明细 
		MonthAndBusinessBean mabb = new MonthAndBusinessBean();
		mabb.setBusinessAccount(bean.getOSAccount());
		mabb.setMonth(m);
		mabb.setYear(y);
		if(iMonthBusinessDemandService.findByMonthAndBusinessBean(mabb) == null) {
			
			mabb.setAccount(user.getUserName());
		}else{
			mabb = iMonthBusinessDemandService.findByMonthAndBusinessBean(mabb);
		}
	
		
		
		//当前消费
		double money1 = mabb.getMoney();
		//当前的使用时间
		long  time1 = mabb.getNowTime();
		
		switch (mealBean.getMealType()) {
		case 1:
		System.out.println("暂时不清楚 123 对应那种类型 的资费");	
	/*
	 * 	包月 不设置 money1
	 * 
	 * 套餐 先得出对应 的业务账户 bus 共时间    
	 * 
	 * MonthBus 已用时间   相减 再得 进行乘除 加减
	 * 
	 *  设置资费类型
	 * 按时就直接 进行乘除 加减
	 */
		
		
			break;
		case 2:
			
			break;
		case 3:
			
			break;

		default:
			System.err.println("异常！！！没有资费类型");
			break;
		}
		iMonthBusinessHandleService.saveMonthAndBusinessBean(mabb);
		return mabb;
		
	}
}
