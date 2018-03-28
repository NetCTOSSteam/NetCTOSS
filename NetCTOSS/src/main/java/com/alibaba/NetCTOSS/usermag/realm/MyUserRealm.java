package com.alibaba.NetCTOSS.usermag.realm;

import java.util.HashSet;
import java.util.Set;

import javax.annotation.Resource;

import org.apache.shiro.authc.AuthenticationException;
import org.apache.shiro.authc.AuthenticationInfo;
import org.apache.shiro.authc.AuthenticationToken;
import org.apache.shiro.authc.SimpleAuthenticationInfo;
import org.apache.shiro.authz.AuthorizationInfo;
import org.apache.shiro.authz.SimpleAuthorizationInfo;
import org.apache.shiro.realm.AuthorizingRealm;
import org.apache.shiro.subject.PrincipalCollection;

import com.alibaba.NetCTOSS.beans.userAndBusBean.UserBean;
import com.alibaba.NetCTOSS.usermag.service_demand.IUserDemandService;

public class MyUserRealm extends AuthorizingRealm {

	@Resource
	private IUserDemandService userDemandServiceImpl;
	/**
	 * 为当限前登录的用户授予角色和权限
	 */
	@Override
	protected AuthorizationInfo doGetAuthorizationInfo(PrincipalCollection principal) {
		// TODO Auto-generated method stub
		SimpleAuthorizationInfo authorizationInfo = new SimpleAuthorizationInfo();

		Set<String> permission = new HashSet<>();

		permission.add("用户自服务系统");

		authorizationInfo.setStringPermissions(permission);
		return authorizationInfo;
	}

	/**
	 * 验证当前登录的用户
	 */
	@Override
	protected AuthenticationInfo doGetAuthenticationInfo(AuthenticationToken token) throws AuthenticationException {
		// TODO Auto-generated method stub
		String loginName = (String) token.getPrincipal();
		String password = (String) token.getCredentials();
		UserBean bean = new UserBean();
		bean.setLoginName(loginName);
		bean.setPassword(password);
		UserBean user = userDemandServiceImpl.findByBean(bean);
		if (user != null) {
			AuthenticationInfo authcInfo = new SimpleAuthenticationInfo(user.getLoginName(), user.getPassword(),
					getName());
			return authcInfo;
		} else {
			return null;
		}
	}

}
