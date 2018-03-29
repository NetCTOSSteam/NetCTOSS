package com.alibaba.NetCTOSS.billmag.mapper_demand;

import java.util.List;

import org.apache.ibatis.annotations.Param;

import com.alibaba.NetCTOSS.beans.billBean.ServiceAndBusinessBean;

public interface ServiceBusinessMapper {
	/**
	 * 按时间查询 当前时间 00：00到 23：59：59 
	 * 
	 * 数据是外部的  每天定时拿出进行计算 而更新 年月日 等 各个表中的数据
	 * 
	 * 但是数据一定是完成了即有结束时间  所以 其实数据库不和理 或者  开始 到结束不能超出一天 为一条数据
	 * 
	 * 一 跨天  二跨月 三跨年
	 * 
	 * 1.所有的账户
	 * 2.当天用时 没办法查询做到 
	 * 
	 * 
	 * 
	 * @param bean
	 * @return
	 */
	public List<ServiceAndBusinessBean> findServiceBusByBean(@Param("bean")ServiceAndBusinessBean bean);

	/**
	 * 根据账务账号（即OS账号）查询该业务下面服务器的详细信息
	 * @param f_os_account os账号
	 * @return 返回服务器信息对象
	 */
	public ServiceAndBusinessBean findOneServiceBusByBean(String f_os_account);
	

}
