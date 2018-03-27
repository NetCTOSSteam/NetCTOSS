package com.alibaba.NetCTOSS.admmag.controller;

import javax.servlet.http.HttpServletRequest;

import org.apache.shiro.SecurityUtils;
import org.apache.shiro.authc.UsernamePasswordToken;
import org.apache.shiro.subject.Subject;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.alibaba.NetCTOSS.beans.admAndRoleBean.AdministratorBean;

@Controller
@RequestMapping("/admin")
public class AdminController {
	/**
	 * 用户登录
	 * @param admin
	 * @param request
	 * @return
	 */
	@RequestMapping(value = "/login", method = { RequestMethod.POST }, produces = { "application/json" })
	public String login(AdministratorBean admin, String code, HttpServletRequest request) {
		Subject subject = SecurityUtils.getSubject();//获取subject主体内容
		UsernamePasswordToken token = new UsernamePasswordToken(admin.getLoginName(), admin.getPassword());

		// 得到后台随机生成验证码的数字是多少
		String CODE = (String) request.getAttribute("code");

		try {
			subject.login(token);
			/*
			 * Session session = subject.getSession(); System.out.println("sessionId:"
			 * +session.getId()); System.out.println("sessionHost:" + session.getHost());
			 * System.out.println("sessionTimeout:" + session.getTimeout());
			 * session.setAttribute("info", "session的数据");
			 */
			if (!CODE.equals(code)) {
				request.setAttribute("errorMsg", "验证码输入错误！");
				return "login";
			}else {
				return "redirect:/static/html/index.html";
			}
		} catch (Exception e) {
			e.printStackTrace();
			request.setAttribute("admin", admin);
			request.setAttribute("errorMsg", "用户名或密码错误！");
			return "login";
		}
	}
}