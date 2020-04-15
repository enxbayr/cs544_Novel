package edu.mum.amqp;

import edu.mum.domain.Order;
import edu.mum.domain.UserRole;

public interface OrderMQService {
    public void publish(UserRole role, Order order);
}
