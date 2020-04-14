package edu.mum.service;

import java.util.List;
import java.util.Set;
import edu.mum.domain.Order;
import edu.mum.domain.OrderItem;
import edu.mum.domain.OrderStatus;
import edu.mum.domain.User;

public interface OrderItemService {
	void processOrder(String orderNum, OrderStatus orderStatus);
	void setOrderItem(Set<OrderItem> orderItems);
	List<Order> getOrderByUser(User user);

	public List<Order> getAll();
	public Order save(Order order);	
	public List<Order> getOrdersByStatus(OrderStatus status);
	public Order findPropertyById(Long id);
	public Order findPropertyByNumber(String orderNumber);
	public void delete(Long id);	
}
