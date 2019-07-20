package com.jmstest.JmsTestSpringBoot.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.jmstest.JmsTestSpringBoot.Endpoint.MessageSender;

@RestController
public class MyFirstController {
	
	@Autowired
	MessageSender sender;
	
	@RequestMapping("/produce")
	public void producer() {
		sender.send();
	}
}
