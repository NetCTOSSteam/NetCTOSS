package com.alibaba.NetCTOSS.aspects;
import java.util.Arrays;
import java.util.Date;

import javax.annotation.Resource;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.AfterReturning;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Pointcut;
import org.springframework.stereotype.Component;

import com.alibaba.NetCTOSS.beans.logBean.DoLogBean;
import com.alibaba.NetCTOSS.logmag.service_handle.IDoLogHandleService;
import com.alibaba.NetCTOSS.util.MyLog;

@Component
@Aspect
public class DoLogAspect {

	@Resource
	private IDoLogHandleService doLogHandleServiceImpl;

	@Pointcut(value = "execution(* com.alibaba.NetCTOSS.*mag.service_handle.impl.*ServiceImpl.*(..))")
	public void pointcutExpression() {
		
	}

	@AfterReturning(pointcut="pointcutExpression()&&@annotation(myLog)",returning="ret")
	public void afterReturningAdvice(JoinPoint jp,MyLog myLog, Object ret) {
//		HttpServletRequest request = ((ServletRequestAttributes) RequestContextHolder.getRequestAttributes())
//				.getRequest();
		
		DoLogBean log = new DoLogBean();
		log.setAdmName("xb");
		log.setLoginName("123456");
		log.setIP("127.0.0.1");
		log.setPlace(myLog.place());
		log.setAction(myLog.action());
		Object[] args = jp.getArgs();// 获取目标方法传入的参数
		log.setData(Arrays.toString(args));
		log.setTime(new Date());
		doLogHandleServiceImpl.saveDoLogBean(log);
		
	}

}
