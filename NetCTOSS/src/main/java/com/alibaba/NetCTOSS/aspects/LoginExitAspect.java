package com.alibaba.NetCTOSS.aspects;

import java.util.Date;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;

import org.apache.shiro.web.util.WebUtils;
import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.AfterReturning;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Pointcut;
import org.springframework.stereotype.Component;
import org.springframework.web.context.request.RequestContextHolder;
import org.springframework.web.context.request.ServletRequestAttributes;

import com.alibaba.NetCTOSS.beans.admAndRoleBean.AdministratorBean;
import com.alibaba.NetCTOSS.beans.logBean.DoLogBean;
import com.alibaba.NetCTOSS.beans.logBean.LoginExitBean;
import com.alibaba.NetCTOSS.logmag.service_handle.ILoginExitHandleService;
import com.alibaba.NetCTOSS.util.MyLog;

@Component
@Aspect
public class LoginExitAspect {
	
	@Resource
	private ILoginExitHandleService loginExitHandleServiceImpl;
	
	@Pointcut(value="@annotation(com.alibaba.NetCTOSS.util.MyLog)")
	public void pointcutExpression() {}
	
	@AfterReturning(pointcut="pointcutExpression()&&@annotation(myLog)",returning="ret")
	public void afterReturningAdvice(JoinPoint jp,MyLog myLog,Object ret) {
		HttpServletRequest request = ((ServletRequestAttributes) RequestContextHolder.getRequestAttributes()).getRequest();  
		LoginExitBean log=new LoginExitBean();
		log.setName(request.getRemoteUser());//如果认证通过获取到用户名
		log.setAccNumber("123");
		log.setIP(myLog.IP());
		log.setLoginTime(new Date());
		log.setQuitTime(new Date());
		loginExitHandleServiceImpl.saveLoginExitBean(log);
	}
}
