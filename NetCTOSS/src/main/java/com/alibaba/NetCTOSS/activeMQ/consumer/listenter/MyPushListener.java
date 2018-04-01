package com.alibaba.NetCTOSS.activeMQ.consumer.listenter;

import javax.annotation.Resource;
import javax.jms.Message;
import javax.jms.MessageListener;
import javax.jms.TextMessage;

import org.springframework.stereotype.Component;

import com.alibaba.fastjson.JSON;  

@Component("myPushListener")  
public class MyPushListener implements MessageListener {  
	@Resource
	private BillToDay billToDay;
	@Resource
	private BillToMonth billToMonth;
	@Resource
	private BillToYear billToYear;
    @Override  
    public void onMessage(Message message) {  
            TextMessage textMessage = (TextMessage) message;  
            try {  
                //获取数据  
                String jsonStr = textMessage.getText();  
                if (jsonStr != null) {  
                	String map = JSON.parseObject(jsonStr, String.class);  
                    System.out.println("==============================接受到的用户信息 开始====================================");  
                    switch (map) {
					case "开始每日工作！！": 
						  billToDay.execute();
						break;
					case "开始每月工作！！":
						  billToMonth.execute();
						break;
					case "开始每年工作！！":
						  billToYear.execute();
						break;
					default:
						break;
					}
                    
                    System.out.println("==============================接受到的用户信息 结束====================================");  
                }  
            } catch (Exception e) {  
            	System.out.println("消费监听器报错！！");
            }  
        }  
}  