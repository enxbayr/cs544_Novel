package edu.mum.config;

import java.util.Arrays;
import java.util.List;

import org.springframework.amqp.core.AmqpAdmin;
import org.springframework.amqp.core.BindingBuilder;
import org.springframework.amqp.core.Declarable;
import org.springframework.amqp.core.DirectExchange;
import org.springframework.amqp.core.Queue;
import org.springframework.amqp.rabbit.connection.CachingConnectionFactory;
import org.springframework.amqp.rabbit.connection.ConnectionFactory;
import org.springframework.amqp.rabbit.core.RabbitAdmin;
import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class RabbitMQConfig {
	
	@Value("${spring.rabbitmq.host}")
	private String hostname;
	
	@Value("${spring.rabbitmq.port}")
	private String port;

	@Value("${spring.rabbitmq.username}")
	private String username;
	
	@Value("${spring.rabbitmq.password}")
	private String password;
	
	@Value("${rabbitmq.exchange}")
	private String exchange;

	@Value("${rabbitmq.queue.faculty}")
	private String orderQueueFaculty;

	@Value("${rabbitmq.queue.student}")
	private String orderQueueStudent;
	
	@Value("${rabbitmq.routingkey.faculty}")
	private String keyFaculty;

	@Value("${rabbitmq.routingkey.student}")
	private String keyStudent;
	
	@Bean
	public ConnectionFactory connectionFactory() {
		CachingConnectionFactory connectionFactory = new CachingConnectionFactory(hostname);
		connectionFactory.setUsername(username);
		connectionFactory.setPassword(password);
		return connectionFactory;
	}

	@Bean
	public AmqpAdmin amqpAdmin() {
		return new RabbitAdmin(connectionFactory());
	}

	@Bean
	public List<Declarable> orderDirectExchangeBindings() {
		Queue queueFaculty = new Queue(orderQueueFaculty, true);
		Queue queueStudent = new Queue(orderQueueStudent, true);
		DirectExchange orderDirectExchange = new DirectExchange(exchange);

		List<Declarable> bindingList = Arrays.<Declarable>asList(queueFaculty, queueStudent, orderDirectExchange,
				BindingBuilder.bind(queueFaculty).to(orderDirectExchange).with(keyFaculty),
				BindingBuilder.bind(queueStudent).to(orderDirectExchange).with(keyStudent));
		return bindingList;
	}

	@Bean
	public RabbitTemplate orderFacultyTemplate() {
		RabbitTemplate orderFacultyTemplate = new RabbitTemplate(connectionFactory());
		orderFacultyTemplate.setRoutingKey(keyFaculty);
		orderFacultyTemplate.setExchange(exchange);
		orderFacultyTemplate.setReplyTimeout(2000);
		return orderFacultyTemplate;
	}

	@Bean
	public RabbitTemplate orderStudentTemplate() {
		RabbitTemplate orderStudentTemplate = new RabbitTemplate(connectionFactory());
		orderStudentTemplate.setRoutingKey(keyStudent);
		orderStudentTemplate.setExchange(exchange);
		orderStudentTemplate.setReplyTimeout(2000);
		return orderStudentTemplate;
	}
}