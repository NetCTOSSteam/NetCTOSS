package com.alibaba.NetCTOSS.admmag.controller;

import javax.servlet.http.HttpServletRequest;

import org.apache.shiro.SecurityUtils;
import org.apache.shiro.authc.UsernamePasswordToken;
import org.apache.shiro.session.Session;
import org.apache.shiro.subject.Subject;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.alibaba.NetCTOSS.beans.admAndRoleBean.AdministratorBean;
import com.alibaba.NetCTOSS.beans.admAndRoleBean.Messager;

@RestController
@RequestMapping("/admin")
public class AdminController {
	/**
	 * 用户登录
	 * 
	 * @param admin
	 * @param request
	 * @return
	 */
	@RequestMapping(value = "/login", method = { RequestMethod.POST }, produces = { "application/json" })
	public Messager login(AdministratorBean admin, String code, HttpServletRequest request) {
		Subject subject = SecurityUtils.getSubject();// 获取subject主体内容
		UsernamePasswordToken token = new UsernamePasswordToken(admin.getLoginName(), admin.getPassword());
		Session session = subject.getSession();
		// 得到后台随机生成验证码的数字是多少
		String CODE = (String) session.getAttribute("code");
		
		Messager msg = null;
		try {
			subject.login(token);
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
			e.printStackTrace();
			request.setAttribute("admin", admin);
			msg = new Messager(-1, "用户名或者密码错误，请重新输入！");
			return msg;
		}
	}
}