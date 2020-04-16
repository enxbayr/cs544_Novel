package edu.mum.amqp;

import org.springframework.amqp.rabbit.core.RabbitTemplate;

import edu.mum.domain.Orders;

public interface OrderMQService {
	public void publish(RabbitTemplate rabbitTemplate, Orders order);
}
