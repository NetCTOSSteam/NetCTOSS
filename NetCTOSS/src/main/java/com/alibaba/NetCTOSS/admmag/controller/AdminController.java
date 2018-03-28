package com.alibaba.NetCTOSS.admmag.controller;

import java.util.List;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;

import org.apache.shiro.SecurityUtils;
import org.apache.shiro.session.Session;
import org.apache.shiro.subject.Subject;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.alibaba.NetCTOSS.admmag.service_demand.IAdminDemandService;
import com.alibaba.NetCTOSS.admmag.service_handle.IAdminHandleService;
import com.alibaba.NetCTOSS.beans.admAndRoleBean.AdministratorBean;
import com.alibaba.NetCTOSS.beans.admAndRoleBean.Messager;
import com.alibaba.NetCTOSS.usermag.realm.CustomizedToken;
import com.alibaba.NetCTOSS.usermag.realm.LoginType;

@RestController(value="AdminController")
@RequestMapping("/admin")
public class AdminController {
	
	 private static final String ADMIN_LOGIN_TYPE = LoginType.ADMIN.toString();
	
	@Resource
	private IAdminHandleService adminHandleServiceImpl;
	
	@Resource
	private IAdminDemandService adminDemandServiceImpl;
	
	
	/**
	 * 管理员登录
	 * 
	 * @param admin
	 * @param request
	 * @return
	 */
	@RequestMapping(value = "/login", method = { RequestMethod.POST }, produces = { "application/json" })
	public Messager login(AdministratorBean admin, String code, String loginType,HttpServletRequest request) {
		Subject subject = SecurityUtils.getSubject();// 获取subject主体内容
		
		CustomizedToken customizedToken = new CustomizedToken(admin.getLoginName(), admin.getPassword(), ADMIN_LOGIN_TYPE);
		//UsernamePasswordToken token = new UsernamePasswordToken(admin.getLoginName(), admin.getPassword());
		Session session = subject.getSession();
		// 得到后台随机生成验证码的数字是多少
		String CODE = (String) session.getAttribute("code");
		
		Messager msg = null;
		try {
			subject.login(customizedToken);
			/*
			 *  System.out.println("sessionId:"
			 * +session.getId()); System.out.println("sessionHost:" + session.getHost());
			 * System.out.println("sessionTimeout:" + session.getTimeout());
			 * session.setAttribute("info", "session的数据");
			 */
			if (!CODE.equals(code)) {
				msg = new Messager(0, "验证码输入错误，请重新输入！");
				return msg;
			} else {
				msg = new Messager(1, "登录成功！");
				return msg;
			}
		} catch (Exception e) {
			msg = new Messager(-1, "用户名或者密码错误，请重新输入！");
			return msg;
		}
	}
	
	/**
	 * 增加管理员对象
	 * @param administratorBean
	 * @return
	 */
	@RequestMapping(value = "/add", method = { RequestMethod.POST }, produces = { "application/json" })
	public boolean addAdministratorBean(AdministratorBean administratorBean) {
		try {
			adminHandleServiceImpl.saveAdministratorBean(administratorBean);
			return true;
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
			return false;
		}
	}

	/**
	 * 修改管理员对象
	 * @param administratorBean
	 * @return
	 */
	@RequestMapping(value = "/update", method = { RequestMethod.PUT }, produces = { "application/json" })
	public boolean updateAdministratorBean(AdministratorBean administratorBean) {
		try {
			adminHandleServiceImpl.updateAdministratorBean(administratorBean);
			return true;
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
			return false;
		}
	}

	/**
	 * 删除管理员  需要传入管理员信息
	 * @param administratorBean
	 * @return
	 */
	@RequestMapping(value = "/delete", method = { RequestMethod.DELETE }, produces = { "application/json" })
	public boolean deleteAdministratorBean(AdministratorBean administratorBean) {
		try {
			adminHandleServiceImpl.deleteAdministratorBean(administratorBean);
			return true;
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
			return false;
		}
	}

	/**
	 * 跟据参数查询 管理员信息
	 * @param administratorBean
	 * @return
	 */
	@RequestMapping(value = "/{id}", method = { RequestMethod.GET }, produces = { "application/json" })
	public List getAdministratorBeans(AdministratorBean administratorBean) {
		List admins = adminDemandServiceImpl.findAllAdministratorBeansByParam(administratorBean);
		return admins;
	}
	
}