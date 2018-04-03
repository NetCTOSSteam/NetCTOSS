package com.alibaba.NetCTOSS.filter;

import java.util.Date;

import javax.annotation.Resource;
import javax.servlet.ServletContext;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;

import org.apache.shiro.session.Session;
import org.apache.shiro.session.SessionException;
import org.apache.shiro.subject.Subject;
import org.apache.shiro.web.filter.authc.LogoutFilter;
import org.springframework.stereotype.Service;

import com.alibaba.NetCTOSS.admmag.service_demand.IAdminDemandService;
import com.alibaba.NetCTOSS.beans.admAndRoleBean.AdministratorBean;
import com.alibaba.NetCTOSS.beans.logBean.LoginExitBean;
import com.alibaba.NetCTOSS.beans.userAndBusBean.UserBean;
import com.alibaba.NetCTOSS.logmag.service_handle.ILoginExitHandleService;
import com.alibaba.NetCTOSS.usermag.service_demand.IUserDemandService;

@Service  
public class SystemLogoutFilter extends LogoutFilter {  
	
	@Resource
	private ILoginExitHandleService loginExitHandleServiceImpl;

	@Resource
	private IAdminDemandService adminDemandServiceImpl;

	@Resource
	private IUserDemandService userDemandServiceImpl;
	
    @Override  
    protected boolean preHandle(ServletRequest request, ServletResponse response) throws Exception {  
        //在这里执行退出系统前需要清空的数据  
        Subject subject=getSubject(request,response);  
        String redirectUrl=getRedirectUrl(request,response,subject);  
        ServletContext context= request.getServletContext();  
        try {  
            Session session = subject.getSession();
    		AdministratorBean adm = null;
    		UserBean user = null;
    		LoginExitBean login = new LoginExitBean();
    		if (session.getAttribute("user") == null) {
    			adm = (AdministratorBean) session.getAttribute("admin");
    			// 得到管理员登录名
    			String adminLoginName = adm.getLoginName();
    			// 通过管理员登录名查询管理员对象
    			AdministratorBean admin = adminDemandServiceImpl.findAdminByAdminLoginName(adminLoginName);
    			login.setName(admin.getAdminName());// 管理员名字
    			login.setAccNumber("管理员：" + adminLoginName);// 管理员登录名
    		} else {
    			user = (UserBean) session.getAttribute("user");
    			// 得到用户登录名
    			String loginName = user.getLoginName();
    			// 通过管理员登录名查询管理员对象
    			UserBean newUser = userDemandServiceImpl.findByLoginName(loginName);

    			login.setName(newUser.getUserName());// 用户的名字

    			login.setAccNumber("用户：" + user.getLoginName());
    		}
    		login.setIP(session.getHost());
    		login.setQuitTime(new Date());
    		loginExitHandleServiceImpl.saveLoginExitBean(login);
            
    		subject.logout();
            context.removeAttribute("error");  
        }catch (SessionException e){  
            e.printStackTrace();  
        }  
        issueRedirect(request,response,redirectUrl);  
        return false;  
    }  
}  
