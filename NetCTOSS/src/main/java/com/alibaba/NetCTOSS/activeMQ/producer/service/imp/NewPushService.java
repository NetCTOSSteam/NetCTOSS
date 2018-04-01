package com.alibaba.NetCTOSS.activeMQ.producer.service.imp;

import java.util.Map;

import javax.jms.Destination;
import javax.jms.JMSException;
import javax.jms.Message;
import javax.jms.Session;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.jms.core.JmsTemplate;
import org.springframework.jms.core.MessageCreator;
import org.springframework.stereotype.Service;

import com.alibaba.NetCTOSS.activeMQ.producer.service.PushService;
import com.alibaba.fastjson.JSON;

/**
 * 推送内容
 * 
 * @author Administrator
 *
 */
@Service
public class NewPushService implements PushService {

	@Autowired  
    private JmsTemplate jmsTemplate = new JmsTemplate();  
	
	@Autowired  
    @Qualifier("myServiceQueue")  
    private Destination destination; 
	@Override
	public void push(final Object info) {
		// TODO Auto-generated method stub
		pushExecutor.execute(new Runnable() {
			
			@Override
			public void run() {
				System.out.println('a');
				// TODO Auto-generated method stub
				jmsTemplate.send(destination,new MessageCreator() {  
					
                    public Message createMessage(Session session) throws JMSException {  
                        String p = (String) info;  
                        System.out.println('b');
                       return session.createTextMessage(JSON.toJSONString(p));  
                   }  
               });  
//				jmsTemplate.send(destination, new MessageCreator() {  
//                    public Message createMessage(Session session) throws JMSException {  
//                         String p = (String) info;  
//                        return session.createTextMessage(JSON.toJSONString(p));  
//                    }  
//                });  
			}
		});
	}

}
