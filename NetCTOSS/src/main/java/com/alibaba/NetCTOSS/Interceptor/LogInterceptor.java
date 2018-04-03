package com.alibaba.NetCTOSS.Interceptor;

import java.util.Date;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.shiro.SecurityUtils;
import org.apache.shiro.session.Session;
import org.apache.shiro.subject.Subject;
import org.springframework.web.servlet.HandlerInterceptor;
import org.springframework.web.servlet.ModelAndView;

import com.alibaba.NetCTOSS.admmag.service_demand.IAdminDemandService;
import com.alibaba.NetCTOSS.beans.admAndRoleBean.AdministratorBean;
import com.alibaba.NetCTOSS.beans.logBean.LoginExitBean;
import com.alibaba.NetCTOSS.beans.userAndBusBean.UserBean;
import com.alibaba.NetCTOSS.logmag.service_handle.ILoginExitHandleService;
import com.alibaba.NetCTOSS.usermag.service_demand.IUserDemandService;

public class LogInterceptor implements HandlerInterceptor{
	
	@Resource
	private ILoginExitHandleService loginExitHandleServiceImpl;
	
	@Resource
	private IAdminDemandService adminDemandServiceImpl;
	
	@Resource
	private IUserDemandService userDemandServiceImpl;

	
	@Override
	public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler)
			throws Exception {
		// TODO Auto-generated method stub
		System.out.println("MyFirstInterceptor-----preHandle()");
		
		return true;
	}

	@Override
	public void postHandle(HttpServletRequest request, HttpServletResponse response, Object handler,
			ModelAndView modelAndView) throws Exception {
		// TODO Auto-generated method stub
		Subject subject=SecurityUtils.getSubject();
		Session session=subject.getSession();
		AdministratorBean adm=null;
		UserBean user=null;
		LoginExitBean login = new LoginExitBean();
		if(session.getAttribute("user")==null) {
			adm=(AdministratorBean) session.getAttribute("admin");
			//得到管理员登录名
			String adminLoginName = adm.getLoginName();
			//通过管理员登录名查询管理员对象
			AdministratorBean admin = adminDemandServiceImpl.findAdminByAdminLoginName(adminLoginName);
			login.setName(admin.getAdminName());//管理员名字
			login.setAccNumber("管理员："+adminLoginName);//管理员登录名
		}else {
			user=(UserBean) session.getAttribute("user");
			//得到用户登录名
			String loginName = user.getLoginName();
			//通过管理员登录名查询管理员对象
			UserBean newUser = userDemandServiceImpl.findByLoginName(loginName);
			
			login.setName(newUser.getUserName());//用户的名字
			
			login.setAccNumber("用户："+user.getLoginName());
		}
		login.setIP(session.getHost());
		login.setLoginTime(new Date());
		loginExitHandleServiceImpl.saveLoginExitBean(login);
	
	}

	@Override
	public void afterCompletion(HttpServletRequest request, HttpServletResponse response, Object handler, Exception ex)
			throws Exception {
		// TODO Auto-generated method stub
		
	}

}
