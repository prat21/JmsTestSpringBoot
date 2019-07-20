package com.jmstest.JmsTestSpringBoot.Endpoint;

import org.springframework.jms.annotation.JmsListener;
import org.springframework.stereotype.Component;

import com.jmstest.JmsTestSpringBoot.Model.Employee;

@Component
public class MessageReceiver {
	
	@JmsListener(destination="pratikQueue")
	public void receive(Employee emp) {
		System.out.println("Message received by consumer: "+emp);			
	}
}
