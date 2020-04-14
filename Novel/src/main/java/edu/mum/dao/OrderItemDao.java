package edu.mum.dao;

import java.util.List;
import edu.mum.domain.Order;
import edu.mum.domain.OrderItem;

public interface OrderItemDao extends GenericDao<OrderItem> {
	public OrderItem getOrderById(Long id);
	public List<OrderItem> getOrderItemByOrder(Order order);
}