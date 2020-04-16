package edu.mum.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import edu.mum.dao.OrderItemDao;
import edu.mum.domain.OrderItem;
import edu.mum.service.OrderItemService;

@Service
public class OrderItemServiceImpl implements OrderItemService {

	@Autowired
	private OrderItemDao orderItemRepository;

	@Override
	public List<OrderItem> getOrderItemsByOrderId(Long id) {
		return this.orderItemRepository.getOrderItemByOrder(id);
	}

	@Override
	public List<OrderItem> getAll() {
		return this.orderItemRepository.findAll();
	}

	@Override
	public void save(OrderItem orderItem) {
		this.orderItemRepository.save(orderItem);
	}

	@Override
	public void delete(Long id) {
		this.orderItemRepository.delete(id);

	}

}
