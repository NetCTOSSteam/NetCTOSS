package com.alibaba.NetCTOSS.util;

public @interface MyLog {

	/**
	 * 管理员名字
	 * @return
	 */
	String admName() default "";  
	
	/**
	 * 管理员账户
	 * @return
	 */
	String loginName() default "";  
	
	/**
	 * 操作的模块名  
	 * @return
	 */
	String place() default "";  
	
	/**
	 * 什么操作 增 1   删 2   改3
	 * @return
	 */
	int action() ;  
	
	/**
	 * 操作的数据
	 * @return
	 */
	String data() default "";  
	
	/**
	 * 登录IP
	 * @return
	 */
	String IP() default "";  
}
