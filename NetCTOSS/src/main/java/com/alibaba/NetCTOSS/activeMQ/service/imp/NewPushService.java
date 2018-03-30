//package com.alibaba.NetCTOSS.activeMQ.service.imp;
//
//import java.util.Map;
//
//import javax.jms.Destination;
//import javax.jms.JMSException;
//import javax.jms.Message;
//import javax.jms.Session;
//
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.beans.factory.annotation.Qualifier;
//import org.springframework.jms.core.JmsTemplate;
//import org.springframework.jms.core.MessageCreator;
//import org.springframework.stereotype.Service;
//
//import com.alibaba.NetCTOSS.activeMQ.service.PushService;
//import com.alibaba.fastjson.JSON;
//
///**
// * 推送内容
// * 
// * @author Administrator
// *
// */
//@Service
//public class NewPushService implements PushService {
//
//	@Autowired  
//    private JmsTemplate jmsTemplate;  
//	
//	@Autowired  
//    @Qualifier("myServiceQueue")  
//    private Destination destination; 
//	@Override
//	public void push(final Object info) {
//		// TODO Auto-generated method stub
//		pushExecutor.execute(new Runnable() {
//			
//			@Override
//			public void run() {
//				// TODO Auto-generated method stub
//				jmsTemplate.send(destination,new MessageCreator() {  
//                    public Message createMessage(Session session) throws JMSException {  
//                        Map p = (Map) info;  
//                       return session.createTextMessage(JSON.toJSONString(p));  
//                   }  
//               });  
////				jmsTemplate.send(destination, new MessageCreator() {  
////                    public Message createMessage(Session session) throws JMSException {  
////                         String p = (String) info;  
////                        return session.createTextMessage(JSON.toJSONString(p));  
////                    }  
////                });  
//			}
//		});
//	}
//
//}
