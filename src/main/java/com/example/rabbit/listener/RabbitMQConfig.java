package com.example.rabbit.listener;

import org.springframework.amqp.core.Binding;
import org.springframework.amqp.core.BindingBuilder;
import org.springframework.amqp.core.Queue;
import org.springframework.amqp.core.TopicExchange;
import org.springframework.amqp.rabbit.connection.CachingConnectionFactory;
import org.springframework.amqp.rabbit.connection.ConnectionFactory;
import org.springframework.amqp.rabbit.listener.MessageListenerContainer;
import org.springframework.amqp.rabbit.listener.SimpleMessageListenerContainer;
import org.springframework.amqp.rabbit.listener.adapter.MessageListenerAdapter;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class RabbitMQConfig {

	// definir a fila que estah ouvindo
	private static final String MY_QUEUE = "MyQueue";

	@Bean
	Queue myQueue() {
		// durabilidade
		return new Queue(MY_QUEUE, true);

	}

	// prover a conexao com fila
	@Bean
	ConnectionFactory connectionFactory() {
		CachingConnectionFactory cacheF = new CachingConnectionFactory("localhost");
		cacheF.setUsername("guest"); // default
		cacheF.setPassword("guest"); // default
		return cacheF;
	}

	// interligar a fila, a conexao e o listener/ouvinte (este projeto)
	@Bean
	MessageListenerContainer messageListenerContainer() {
		SimpleMessageListenerContainer msg = new SimpleMessageListenerContainer();
		msg.setConnectionFactory(connectionFactory());
		msg.setQueueNames(MY_QUEUE);
		msg.setMessageListener(new RabbitMQMessageListener());
		return msg;
	}
}
