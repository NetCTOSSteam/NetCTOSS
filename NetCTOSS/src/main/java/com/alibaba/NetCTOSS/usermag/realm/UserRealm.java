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

import com.alibaba.NetCTOSS.admmag.service_demand.IRoleDemandService;
import com.alibaba.NetCTOSS.beans.admAndRoleBean.RoleBean;
import com.alibaba.NetCTOSS.beans.userAndBusBean.UserBean;
import com.alibaba.NetCTOSS.usermag.service_demand.IUserDemandService;

public class UserRealm extends AuthorizingRealm {

	@Resource
	private IUserDemandService userDemandServiceImpl;

	@Resource
	private IRoleDemandService roleDemandServiceImpl;

	/**
	 * 为当限前登录的用户授予角色和权限
	 */
	@Override
	protected AuthorizationInfo doGetAuthorizationInfo(PrincipalCollection principal) {
		// TODO Auto-generated method stub
		String userName = (String) principal.getPrimaryPrincipal();

		SimpleAuthorizationInfo authorizationInfo = new SimpleAuthorizationInfo();

		RoleBean role = userDemandServiceImpl.getRole(userName);
		if (role != null) {
			String roleName = role.getRoleName();

			Set<String> roles = new HashSet<>();

			roles.add(roleName);

			authorizationInfo.setRoles(roles);
			authorizationInfo.setStringPermissions(roleDemandServiceImpl.getPermissions(roleName));
		}

		return authorizationInfo;
	}

	/**
	 * 验证当前登录的用户
	 */
	@Override
	protected AuthenticationInfo doGetAuthenticationInfo(AuthenticationToken token) throws AuthenticationException {
		// TODO Auto-generated method stub

		// 1. 把AuthenticationToken转换为CustomizedToken
		CustomizedToken customizedToken = (CustomizedToken) token;

		String loginName = (String) customizedToken.getPrincipal();

		UserBean user = userDemandServiceImpl.findByLoginName(loginName);
		System.out.println(user);
		if (user != null) {
			AuthenticationInfo authcInfo = new SimpleAuthenticationInfo(user.getLoginName(), user.getPassword(),
					getName());
			
			return authcInfo;
		} else {
			return null;
		}
	}

}
