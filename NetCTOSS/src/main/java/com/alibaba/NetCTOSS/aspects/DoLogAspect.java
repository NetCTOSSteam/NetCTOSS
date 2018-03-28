package com.alibaba.NetCTOSS.aspects;

import java.util.Arrays;

import javax.annotation.Resource;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.AfterReturning;
import org.aspectj.lang.annotation.Pointcut;
import org.springframework.stereotype.Component;

import com.alibaba.NetCTOSS.beans.logBean.DoLogBean;
import com.alibaba.NetCTOSS.logmag.service_handle.IDoLogHandleService;
import com.alibaba.NetCTOSS.util.MyLog;

@Component
@Resource
public class DoLogAspect {
	
	@Resource
	private IDoLogHandleService doLogHandleServiceImpl;
	
	@Pointcut(value="@annotation(com.alibaba.NetCTOSS.util.MyLog)")
	public void pointcutExpression() {}
	
	@AfterReturning(pointcut="pointcutExpression()&&@annotation(myLog)",returning="ret")
	public void afterReturningAdvice(JoinPoint jp,MyLog myLog,Object ret) {
		DoLogBean log=new DoLogBean();
		log.setAdmName("xiabai");
		log.setLoginName("123456");
		Object targetObject = jp.getTarget();//获取目标对象
		log.setPlace(targetObject.toString());
		log.setIP(myLog.IP());
		String targetMethod = jp.getSignature().getName();//获取目标方法
		log.setAction(Integer.parseInt(targetMethod));
		Object[] args = jp.getArgs();//获取目标方法传入的参数
		log.setData(Arrays.toString(args));
		doLogHandleServiceImpl.saveDoLogBean(log);
		
		
	}	
	
}
