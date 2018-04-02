package com.alibaba.NetCTOSS.aspects;
import java.util.Arrays;
import java.util.Date;

import javax.annotation.Resource;

import org.apache.shiro.SecurityUtils;
import org.apache.shiro.session.Session;
import org.apache.shiro.subject.Subject;
import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.AfterReturning;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Pointcut;
import org.springframework.stereotype.Component;

import com.alibaba.NetCTOSS.admmag.service_demand.IAdminDemandService;
import com.alibaba.NetCTOSS.beans.admAndRoleBean.AdministratorBean;
import com.alibaba.NetCTOSS.beans.logBean.DoLogBean;
import com.alibaba.NetCTOSS.beans.userAndBusBean.UserBean;
import com.alibaba.NetCTOSS.logmag.service_handle.IDoLogHandleService;
import com.alibaba.NetCTOSS.usermag.service_demand.IUserDemandService;
import com.alibaba.NetCTOSS.util.MyLog;

@Component
@Aspect
public class DoLogAspect {

	@Resource
	private IDoLogHandleService doLogHandleServiceImpl;
	
	@Resource
	private IAdminDemandService adminDemandServiceImpl;
	
	@Resource
	private IUserDemandService userDemandServiceImpl;

	@Pointcut(value = "execution(* com.alibaba.NetCTOSS.*mag.service_handle.impl.*ServiceImpl.*(..))")
	public void pointcutExpression() {
		
	}

	@AfterReturning(pointcut="pointcutExpression()&&@annotation(myLog)",returning="ret")
	public void afterReturningAdvice(JoinPoint jp,MyLog myLog, Object ret) {
		Subject subject=SecurityUtils.getSubject();
		Session session=subject.getSession();
		AdministratorBean adm=null;
		UserBean user=null;
		DoLogBean log = new DoLogBean();
		if(session.getAttribute("user")==null) {
			adm=(AdministratorBean) session.getAttribute("admin");
			//得到管理员登录名
			String adminLoginName = adm.getLoginName();
			//通过管理员登录名查询管理员对象
			AdministratorBean admin = adminDemandServiceImpl.findAdminByAdminLoginName(adminLoginName);
			log.setAdmName(admin.getAdminName());//管理员名字
			log.setLoginName("管理员："+adminLoginName);//管理员登录名
		}else {
			user=(UserBean) session.getAttribute("user");
			//得到用户登录名
			String loginName = user.getLoginName();
			//通过管理员登录名查询管理员对象
			UserBean newUser = userDemandServiceImpl.findByLoginName(loginName);
			
			log.setAdmName(newUser.getUserName());//用户的名字
			
			log.setLoginName("用户："+user.getLoginName());
		}
		log.setIP(session.getHost());
		log.setPlace(myLog.place());
		log.setAction(myLog.action());
		Object[] args = jp.getArgs();// 获取目标方法传入的参数
		log.setData(Arrays.toString(args));
		log.setTime(new Date());
		doLogHandleServiceImpl.saveDoLogBean(log);
	}
}

