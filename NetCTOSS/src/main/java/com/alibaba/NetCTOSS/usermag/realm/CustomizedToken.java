package com.alibaba.NetCTOSS.usermag.realm;

import org.apache.shiro.authc.UsernamePasswordToken;

public class CustomizedToken extends UsernamePasswordToken {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	
	//登录类型，判断是普通用户登录，还是管理员登录
    private String loginType;

    public CustomizedToken(final String LoginName, final String password,String loginType) {
        super(LoginName,password);
        this.loginType = loginType;
    }

    public String getLoginType() {
        return loginType;
    }

    public void setLoginType(String loginType) {
        this.loginType = loginType;
    }

}
