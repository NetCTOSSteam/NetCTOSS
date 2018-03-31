package com.alibaba.NetCTOSS.logmag.mapper_demand;

import java.util.List;
import java.util.Map;
import java.util.Set;

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
	
}
