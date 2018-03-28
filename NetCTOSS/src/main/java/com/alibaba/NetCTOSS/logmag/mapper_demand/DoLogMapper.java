package com.alibaba.NetCTOSS.logmag.mapper_demand;

import java.util.List;
import java.util.Map;

import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Options;
import org.apache.ibatis.annotations.Param;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import com.alibaba.NetCTOSS.beans.logBean.DoLogBean;

public interface DoLogMapper {
	/**
	 * 查询所有日志
	 * @param 
	 * @return
	 */
	public List<DoLogBean> findAll();
	
	/**
	 * 根据参数查询操作日志
	 * @param params
	 * @return
	 */
	public List<DoLogBean> findDoLogsByParams(@Param("params") Map params);
	
	/**
	 * 保存操作日志
	 * @param log
	 * @return
	 */
//	@Insert(value="insert into t_do_log(do_name,do_loginname,do_place,do_data,do_action,do_ip,do_time) values (#{log.do_name},#{log.do_loginname},#{log.do_place},#{log.do_data},#{log.do_action},#{log.do_ip}),#{log.do_time}")
//	@Options(useGeneratedKeys=true,
//	keyProperty="log.id")
	public int saveDoLogBean(@Param("log") DoLogBean log);
	
	
	

}
