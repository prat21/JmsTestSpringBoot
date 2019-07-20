package com.jmstest.JmsTestSpringBoot.Endpoint;

import org.springframework.jms.annotation.JmsListener;
import org.springframework.stereotype.Component;

import com.jmstest.JmsTestSpringBoot.Model.Employee;

@Component
public class MessageReceiver {
	private final String outboundQ = "OutboundQ";
	
	@JmsListener(destination=outboundQ)
	public void receive(Employee emp) {
		System.out.println("Message received by: "+outboundQ+", message is: "+emp);			
	}
}
