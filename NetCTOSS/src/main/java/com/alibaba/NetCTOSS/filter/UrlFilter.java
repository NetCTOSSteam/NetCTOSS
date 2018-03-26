package com.alibaba.NetCTOSS.filter;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.alibaba.NetCTOSS.beans.userAndBusBean.UserBean;

public class UrlFilter implements Filter {
	private List<String> list = new ArrayList<String>();

	@Override
	public void destroy() {
		// TODO Auto-generated method stub
	}

	@Override
	public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain)
			throws IOException, ServletException {
		HttpServletRequest req = (HttpServletRequest) request;
		HttpServletResponse resp = (HttpServletResponse) response;
		
		// 获取到客户端传递过来的URI地址
		String path = req.getRequestURI();

		String objectName = req.getContextPath();//得到项目名称
		String basePath = req.getScheme() + "://" + req.getServerName() + ":" + req.getServerPort()
				+ objectName + "/";//得到项目绝对路径
		// 将路径进行截取 以最后一个/来截取
		String temp = path.substring(path.lastIndexOf("/"));

		if (temp.endsWith(".js") || temp.endsWith(".gif") || temp.endsWith(".jpeg") || temp.endsWith(".css")
				|| temp.endsWith(".png") || temp.endsWith(".jpg")) {
			chain.doFilter(req, resp);
		} else {
			if (list.contains(temp)) {
				chain.doFilter(req, resp);
			} else {
				// 判断当前用户是否登录过 会话是否还在
				HttpSession session = req.getSession(false);
				if (session == null) {
					resp.sendRedirect(basePath+"index.jsp");
				} else {
					UserBean user = (UserBean) session.getAttribute("user");
					if (user != null) {
						chain.doFilter(req, resp);
					} else {
						resp.sendRedirect(basePath+"index.jsp");
					}
				}
			}
		}
	}

	@Override
	public void init(FilterConfig config) throws ServletException {
		String url = config.getInitParameter("filterURL");
		String[] urlarr = url.split(",");
		for (String string : urlarr) {
			list.add(string);
		}
	}
}
