package edu.mum.dao;

import java.time.LocalDate;
import java.util.List;
import edu.mum.domain.Order;
import edu.mum.domain.OrderStatus;
import edu.mum.domain.User;

	public interface OrderDao extends GenericDao<Order>  
	{
		public Order getOrderById(Long id);
		public Order getOrderByNumber(String orderNum);
		public List<Order> getOrderByStatus(OrderStatus orderStatus);
		public List<Order> getOrdersByDate(LocalDate startDate, LocalDate endDate);
		public List<Order> getOrdersByUser(User user);
 	}

