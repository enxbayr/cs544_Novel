package edu.mum.service;

import java.time.LocalDate;
import java.util.List;
import edu.mum.domain.Order;
import edu.mum.domain.OrderStatus;
import edu.mum.domain.User;

public interface OrderService {
	public void setOrderStatus(String orderNum, OrderStatus orderStatus);
	public List<Order> getOrderByUser(User user);
	public List<Order> getAll();
	public void save(Order order);	
	public List<Order> getOrdersByStatus(OrderStatus status);
	public Order findOrderById(Long id);
	public Order findOrderByNumber(String orderNumber);
	public void delete(Long id);
	public List<Order> reportOrderByDate(LocalDate startDate, LocalDate endDate);
}
