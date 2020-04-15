package edu.mum.amqp;

import org.springframework.amqp.rabbit.core.RabbitTemplate;

import edu.mum.domain.Order;

public class OrderMQServiceImpl implements OrderMQService {
    public void publish(RabbitTemplate rabbitTemplate, Order order) {
        rabbitTemplate.convertAndSend(order);
    }
}
