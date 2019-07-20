package com.jmstest.JmsTestSpringBoot.Endpoint;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jms.core.JmsTemplate;
import org.springframework.stereotype.Component;

import com.jmstest.JmsTestSpringBoot.Model.Employee;

@Component
public class MessageSender {
	
	@Autowired
	JmsTemplate jmstemplate;
	
	String inboundQ = "InboundQ";
	String outboundQ = "OutboundQ";
	
	public void send() {
		System.out.println("Sending message to queue");
		for(int i=0;i<10;i++){
			final int j=i;
			/*this.jmstemplate.send("pratikQueue", new MessageCreator() {
				
				@Override
				public Message createMessage(Session session) throws JMSException {
					TextMessage message = session.createTextMessage("My text: "+j);
					System.out.println("Producer has sent the message: "+message.getText());
					return message;
				}
			});*/
			this.jmstemplate.setExplicitQosEnabled(true);
			this.jmstemplate.setTimeToLive(30000);
			this.jmstemplate.convertAndSend(inboundQ, new Employee("name" + j, "address" + j, j),msg->{
				System.out.println("Sending message: "+j);
				msg.setStringProperty("TargetQ", outboundQ);
				return msg;
			});
		}
	}
}
