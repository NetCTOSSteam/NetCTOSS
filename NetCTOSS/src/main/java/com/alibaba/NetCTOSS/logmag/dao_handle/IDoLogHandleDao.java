package com.alibaba.NetCTOSS.logmag.dao_handle;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;

import com.alibaba.NetCTOSS.beans.logBean.DoLogBean;

/**
 * 
 * 操作日志 操作
 * @author Administrator
 *
 */
public interface IDoLogHandleDao extends JpaRepository<DoLogBean, Integer>,JpaSpecificationExecutor<DoLogBean>{
	

	
}
