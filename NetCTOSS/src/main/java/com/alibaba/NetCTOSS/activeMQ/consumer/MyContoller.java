package com.alibaba.NetCTOSS.activeMQ.consumer;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
@RequestMapping("/index")
public class MyContoller {
	@RequestMapping(value="",method=RequestMethod.POST)
	@ResponseBody
	public void index(){
		System.out.println("开始消费消息！！");
		return ;
	}
}
