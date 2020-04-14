package edu.mum.service;

import java.util.List;
import edu.mum.domain.Order;
import edu.mum.domain.OrderStatus;
import edu.mum.domain.User;

public interface OrderService {
	void processOrder(Order order, OrderStatus orderStatus);
	List<Order> getOrderByUser(User user);
	public List<Order> getAll();
	public Order save(Order order);	
	public List<Order> getOrdersByStatus(OrderStatus status);
	public Order findPropertyById(Long id);
	public Order findPropertyByNumber(String orderNumber);
	public void delete(Long id);	
}