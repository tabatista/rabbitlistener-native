package com.example.rabbit.listener;

import org.springframework.amqp.core.Exchange;
import org.springframework.amqp.core.ExchangeBuilder;
import org.springframework.amqp.core.TopicExchange;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class RabbitMQExchangeConfig {
	// tipos de exchange

	@Bean
	Exchange exampleTopicExchange() {
		return new TopicExchange("ExampleExchange"); // nome
	}

	@Bean
	Exchange example2ndExchange() {
		// outro tipo de exchange e outra maneira de criar com o builder
		return ExchangeBuilder.directExchange("Example2ndExchange") // nome
				.autoDelete().internal().build();
	}

	@Bean
	Exchange newTopicExchange() {
		return ExchangeBuilder.topicExchange("TopicTestExchange").autoDelete().durable(true).internal().build();
	}

	@Bean
	Exchange newFanoutExchange() {
		return ExchangeBuilder.fanoutExchange("FanoutTestExchange").autoDelete().durable(false).internal().build();
	}

	@Bean
	Exchange headersExchange() {
		return ExchangeBuilder.headersExchange("HeadersExchange").internal().durable(true).ignoreDeclarationExceptions()
				.build();
	}
}
