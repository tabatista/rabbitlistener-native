package com.example.rabbit.listener;

import org.springframework.amqp.core.Message;
import org.springframework.amqp.core.MessageListener;

public class RabbitMQMessageListener implements MessageListener {

	@Override
	public void onMessage(Message message) {
		System.out.println("message body = [" + new String(message.getBody()) + "]");
	}

}
