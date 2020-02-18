package com.tosh.RabbitMq;

import org.springframework.amqp.core.Binding;
import org.springframework.amqp.core.BindingBuilder;
import org.springframework.amqp.core.Queue;
import org.springframework.amqp.core.TopicExchange;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

@SpringBootApplication
public class RabbitMqApplication {

	private final String EXCHANGE_NAME = "tpcs_tx";
	private final String DEFAULT_PARSING_QUEUE = "default_parser_q";
	private final String ROUTING_KEY = "tips";

	public static void main(String[] args) {
		SpringApplication.run(RabbitMqApplication.class, args);
	}

	@Bean
	public TopicExchange topicExchange(){
		return new TopicExchange(EXCHANGE_NAME);
	}

	@Bean
	public Queue defaultParsingQueue(){
		return new Queue(DEFAULT_PARSING_QUEUE);
	}

	@Bean
	public Binding queueT0ExchangeBinding(){
		return BindingBuilder.bind(defaultParsingQueue()).to(topicExchange()).with(ROUTING_KEY);
	}

}
