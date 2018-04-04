package com.alibaba.NetCTOSS.activeMQ.consumer.listenter;

import java.util.Date;
import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import com.alibaba.NetCTOSS.beans.billBean.AccountDayBean;
import com.alibaba.NetCTOSS.beans.billBean.MonthAndAccountBean;
import com.alibaba.NetCTOSS.beans.billBean.MonthAndBusinessBean;
import com.alibaba.NetCTOSS.beans.billBean.ServiceAndBusinessBean;
import com.alibaba.NetCTOSS.beans.userAndBusBean.BusinessBean;
import com.alibaba.NetCTOSS.beans.userAndBusBean.MealBean;
import com.alibaba.NetCTOSS.beans.userAndBusBean.UserBean;
import com.alibaba.NetCTOSS.billmag.dao_handle.IAccDayHandleDao;
import com.alibaba.NetCTOSS.billmag.dao_handle.IMonthAccHandleDao;
import com.alibaba.NetCTOSS.billmag.dao_handle.IMonthBusinessHandleDao;
import com.alibaba.NetCTOSS.billmag.service_demand.IAccDayDemandService;
import com.alibaba.NetCTOSS.billmag.service_demand.IMonthAccDemandService;
import com.alibaba.NetCTOSS.billmag.service_demand.IMonthBusinessDemandService;
import com.alibaba.NetCTOSS.billmag.service_demand.IServiceBusinessDemandService;
import com.alibaba.NetCTOSS.billmag.service_handle.IAccDayHandleService;
import com.alibaba.NetCTOSS.usermag.service_demand.IBusinessDemandService;
import com.alibaba.NetCTOSS.usermag.service_demand.IUserDemandService;
import com.alibaba.NetCTOSS.util.MyDateUtil;

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

@Service("day")
public class BillToDay  {

	
	@Resource
	private IServiceBusinessDemandService  iServiceBusinessDemandService;
	
	@Resource
	private IAccDayHandleDao IAccDayHandleDao;
	@Resource
	private IAccDayDemandService iAccDayDemandService;
	
	@Resource
	private IUserDemandService iUserDemandService;
	@Resource
	private IBusinessDemandService iBusinessDemandService;
	
	@Resource
	private IMonthAccDemandService iMonthAccDemandService;
	@Resource
	private IMonthAccHandleDao iMonthAccHandleDao;
	
	@Resource
	private IMonthBusinessDemandService iMonthBusinessDemandService;
	@Resource
	private IMonthBusinessHandleDao iMonthBusinessHandleDao;
	
	
	public void execute()  {
		// TODO Auto-generated method stub
	
		try {
			Date date = new Date();
			
			String dates = MyDateUtil.DataToString(date, "yyyy-MM-dd");
			//当前时间进行拆分  得到 年 月 日
			String[] das = dates.split("-");
			int yea = Integer.valueOf( das[0]);
			int mont = Integer.valueOf(das[1]);
			int day = Integer.valueOf(das[2]);
			//查询出当天的 服务器使用 记录
			ServiceAndBusinessBean bean = new ServiceAndBusinessBean();
			bean.setStartTime(date);
			List<ServiceAndBusinessBean> li = iServiceBusinessDemandService.findServiceBusByBean(bean);

			
			for (ServiceAndBusinessBean serviceAndBusinessBean : li) {
				AccountDayBean accountDayBean = saveAccDayBill(serviceAndBusinessBean,yea,mont,day);
				
				Double money = updateMonthBus(serviceAndBusinessBean,yea,mont,day);
				MonthAndAccountBean monthAndAccountBean = updateMonthAcc(serviceAndBusinessBean,yea,mont,day,money);
				
			}
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
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
		
		IAccDayHandleDao.save(accountDayBean);
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
		if(maab.getMoney() == null) {
			maab.setMoney(money);
		}else {
			maab.setMoney(maab.getMoney()+money);
		}
		
		if(iMonthAccDemandService.findByMonthAndAccountBean(maab) == null) {
			maab.setIDcard(user.getIdCard());
			maab.setName(user.getUserName());
			maab.setStatus(1);
			iMonthAccHandleDao.save(maab);
		}else{
			maab = iMonthAccDemandService.findByMonthAndAccountBean(maab);
			System.out.println(maab.getId());
			iMonthAccHandleDao.saveAndFlush(maab);
		}
		
		return maab;
	}
	/**
	 * 修改当月 每一个业务账户的 账单
	 */
	private Double updateMonthBus(ServiceAndBusinessBean bean,int y ,int m , int d) {
		
		UserBean user = new UserBean();
		BusinessBean bus = new BusinessBean();
		MealBean mealBean = new MealBean();
		//资费增加量
		Double mon = null;
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
			mabb.setNowTime(0L);
			mon = newdd(bean,mabb, mealBean);
			iMonthBusinessHandleDao.save(mabb);
		}else{
			mabb = iMonthBusinessDemandService.findByMonthAndBusinessBean(mabb);
			mon = newdd(bean,mabb, mealBean);
			iMonthBusinessHandleDao.saveAndFlush(mabb);
		}
		
		return mon;
		
	}
	private Double newdd(ServiceAndBusinessBean bean,MonthAndBusinessBean mabb,MealBean mealBean) {
				Double mon = null;
				//当前消费
				Double money1 = mabb.getMoney();
				//当前的使用时间
				long  time1 = bean.getOnlineTimr();
				
				switch (mealBean.getMealType()) {
				//0代表包月
				case 0:
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
				mabb.setMoney(mealBean.getMealBasicMoney());
				mon = 0.0;
					break;
				//1代表包时  包时按照小时来计费的
				case 1:
					double dd1 =  ((double)time1)/3600000; 
					
					mabb.setMoney(money1+dd1*mealBean.getMealMoney());
					mabb.setNowTime(mabb.getNowTime()+time1);
					mon= dd1*mealBean.getMealMoney();
					break;
				//2代表是套餐计费 
				case 2:
					//当天用时
					double dd =  ((double)time1)/3600000; 
					
					//之前总共用时 毫秒
					Long ti = mabb.getNowTime();
					//套餐时间 小时
					int tim = mealBean.getMealTime();
					double tt = 0;
					
					if((tt=(tim-ti))>0) {
						mabb.setMoney(mealBean.getMealBasicMoney());
						mabb.setNowTime(mabb.getNowTime()+time1);
						mon = 0.0;
					}else {
						mabb.setMoney(mealBean.getMealBasicMoney()+tt/3600000*mealBean.getMealMoney());
						mon = tt/3600000*mealBean.getMealMoney();
					}
					
					
					break;

				default:
					System.err.println("异常！！！没有资费类型");
					break;
				}
				return mon;
	}
}
