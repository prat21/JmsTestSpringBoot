package com.jmstest.JmsTestSpringBoot.Endpoint;

import javax.jms.JMSException;
import javax.jms.Message;
import javax.jms.Session;
import javax.jms.TextMessage;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jms.core.JmsTemplate;
import org.springframework.jms.core.MessageCreator;
import org.springframework.jms.core.MessagePostProcessor;
import org.springframework.stereotype.Component;

import com.jmstest.JmsTestSpringBoot.Model.Employee;

@Component
public class MessageSender {
	
	@Autowired
	JmsTemplate jmstemplate;
	
	public void send() {
		System.out.println("Sending message to queue");
		for(int i=0;i<100;i++){
			final int j=i;
			/*this.jmstemplate.send("pratikQueue", new MessageCreator() {
				
				@Override
				public Message createMessage(Session session) throws JMSException {
					TextMessage message = session.createTextMessage("My text: "+j);
					System.out.println("Producer has sent the message: "+message.getText());
					return message;
				}
			});*/
			
			this.jmstemplate.convertAndSend("pratikQueue",new Employee("name"+j,"address"+j,j),new MessagePostProcessor() {
				
				@Override
				public Message postProcessMessage(Message msg) throws JMSException {
					System.out.println("Sending message: "+j);
					return msg;
				}
			});
		}
	}
}
