package com.jmstest.JmsTestSpringBoot.Endpoint;

import javax.jms.JMSException;
import javax.jms.Message;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jms.annotation.JmsListener;
import org.springframework.jms.core.JmsTemplate;
import org.springframework.stereotype.Component;

@Component
public class MessageRouter {
	@Autowired
	JmsTemplate jmstemplate;
	
	private final String expiredQ = "ActiveMQ.DLQ";

	@JmsListener(destination=expiredQ)
	public void receive(Message msg) {
		String TargetQ;
		try {
			TargetQ = msg.getStringProperty("TargetQ");
			System.out.println("Routing message to: "+TargetQ);
			//jmstemplate.convertAndSend(TargetQ, msg);
			jmstemplate.send(TargetQ, session->msg);
		} catch (JMSException e) {
			e.printStackTrace();
		}
				
	}
	
}
