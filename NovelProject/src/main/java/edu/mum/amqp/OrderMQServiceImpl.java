package edu.mum.amqp;

import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.stereotype.Service;

import edu.mum.domain.Orders;
import edu.mum.domain.UserRole;

@Service
public class OrderMQServiceImpl implements OrderMQService {
	
	@Autowired
	private ApplicationContext context;
	
    public void publish(UserRole role, Orders order) {
    	RabbitTemplate orderTemplate = null;
    	if(role == UserRole.FACULTY)
    		orderTemplate =  context.getBean("orderFacultyTemplate",RabbitTemplate.class);
    	else
    		orderTemplate =  context.getBean("orderStudentTemplate",RabbitTemplate.class);
    	orderTemplate.convertAndSend(order);
    }
}
