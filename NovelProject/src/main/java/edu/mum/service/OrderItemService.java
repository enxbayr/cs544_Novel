package edu.mum.service;

import java.util.List;
import edu.mum.domain.OrderItem;

public interface OrderItemService {
	public List<OrderItem> getOrderItemsByOrderId(Long id);
	public List<OrderItem> getAll();
	public void save(OrderItem orderItem);	
	public void delete(Long id);
}
