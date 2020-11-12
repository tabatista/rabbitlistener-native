package com.example.rabbit.listener;

import org.springframework.amqp.core.Exchange;
import org.springframework.amqp.core.ExchangeBuilder;
import org.springframework.amqp.core.TopicExchange;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class RabbitMQExchangeConfig {

	@Bean
	Exchange exampleTopicExchange() {
		// tipo de exchange - nome
		return new TopicExchange("ExampleExchange");
	}

	@Bean
	Exchange example2ndExchange() {
		// outro tipo de exchange e outra maneira de criar com o builder
		return ExchangeBuilder.directExchange("Example2ndExchange") // nome
				.autoDelete().internal().build();
	}
}
