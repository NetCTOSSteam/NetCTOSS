package com.alibaba.NetCTOSS.activeMQ.service;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

/**
 * 创建一个公共的接口
 * @author Administrator
 *
 */
public interface PushService {  
	  
    public final ExecutorService pushExecutor = Executors.newFixedThreadPool(10);  
      
    public void push(Object info);  
      
} 