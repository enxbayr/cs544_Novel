package edu.mum.amqp;

import edu.mum.domain.Orders;
import edu.mum.domain.UserRole;

public interface OrderMQService {
    public void publish(UserRole role, Orders order);
}
