package com.example.rabbit.listener;

import org.springframework.amqp.core.Queue;
import org.springframework.amqp.core.QueueBuilder;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class RabbitMQQueueConfiguration {

	@Bean
	Queue exampleQueue() {
		// titulo-nome da fila / durabilidade - sobrevive ao restart do server
		return new Queue("ExampleQueue", false);
	}

	@Bean
	Queue exampleSecondQueue() {
		// caracteristicas de um outro jeito de criar uma fila
		return QueueBuilder.durable("Example2ndQueue") // nome
				.autoDelete().exclusive().build();
	}

}
