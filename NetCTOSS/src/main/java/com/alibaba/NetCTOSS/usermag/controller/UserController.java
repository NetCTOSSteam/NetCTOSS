package com.alibaba.NetCTOSS.usermag.controller;

import javax.servlet.http.HttpServletRequest;

import org.apache.shiro.SecurityUtils;
import org.apache.shiro.session.Session;
import org.apache.shiro.subject.Subject;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.alibaba.NetCTOSS.beans.admAndRoleBean.Messager;
import com.alibaba.NetCTOSS.beans.userAndBusBean.UserBean;
import com.alibaba.NetCTOSS.usermag.realm.CustomizedToken;
import com.alibaba.NetCTOSS.usermag.realm.LoginType;

@RestController
@RequestMapping("/user")
public class UserController {
	
	 private static final String USER_LOGIN_TYPE = LoginType.USER.toString();
	/**
	 * 用户账户登录
	 * 
	 * @param admin
	 * @param request
	 * @return
	 */
	@RequestMapping(value = "/login", method = { RequestMethod.POST }, produces = { "application/json" })
	public Messager login(UserBean user, String code, String loginType,HttpServletRequest request) {
		Subject subject = SecurityUtils.getSubject();// 获取subject主体内容
		CustomizedToken customizedToken = new CustomizedToken(user.getLoginName(), user.getPassword(), USER_LOGIN_TYPE);
		//UsernamePasswordToken token = new UsernamePasswordToken();
		Session session = subject.getSession();
		// 得到后台随机生成验证码的数字是多少
		String CODE = (String) session.getAttribute("code");

		Messager msg = null;
		try {
			subject.login(customizedToken);
			
			session.setAttribute("user", user);
			/*
			 * System.out.println("sessionId:" +session.getId());
			 * System.out.println("sessionHost:" + session.getHost());
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
}
