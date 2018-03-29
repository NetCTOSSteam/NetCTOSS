package com.alibaba.NetCTOSS.admmag.realm;

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

import com.alibaba.NetCTOSS.admmag.service_demand.IAdminDemandService;
import com.alibaba.NetCTOSS.admmag.service_demand.IRoleDemandService;
import com.alibaba.NetCTOSS.beans.admAndRoleBean.AdministratorBean;
import com.alibaba.NetCTOSS.beans.admAndRoleBean.RoleBean;
import com.alibaba.NetCTOSS.usermag.realm.CustomizedToken;

public class AdminRealm extends AuthorizingRealm {

	@Resource
	private IAdminDemandService adminDemandServiceImpl;

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

		RoleBean role = adminDemandServiceImpl.getRole(userName);
		String roleName = null;
		if (role != null) {
			roleName = role.getRoleName();
			Set<String> roles = new HashSet<>();

			roles.add(roleName);

			authorizationInfo.setRoles(roles);
			authorizationInfo.setStringPermissions(roleDemandServiceImpl.getPermissions(role.getRoleName()));
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

		String adminLoginName = (String) customizedToken.getPrincipal();

		AdministratorBean admin = adminDemandServiceImpl.findAdminByAdminLoginName(adminLoginName);
		if (admin != null) {
			AuthenticationInfo authcInfo = new SimpleAuthenticationInfo(admin.getLoginName(), admin.getPassword(),
					getName());
			return authcInfo;
		} else {
			return null;
		}
	}

}
