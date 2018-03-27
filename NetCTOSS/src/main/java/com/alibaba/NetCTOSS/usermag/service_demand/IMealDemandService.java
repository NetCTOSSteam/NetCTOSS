package com.alibaba.NetCTOSS.usermag.service_demand;

import com.github.pagehelper.Page;

/**
 * 资费 的查询接口
 * @author Administrator
 *
 */
public interface IMealDemandService {
	/**
	 * 初始页面的分页查询
	 * @return 分页对象
	 */
	public Page<?> findAllAndPage();
	
	
	
	
}
