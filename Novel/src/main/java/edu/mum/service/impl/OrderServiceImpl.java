package edu.mum.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import edu.mum.dao.OrderDao;
import edu.mum.domain.Menu;
import edu.mum.domain.Order;
import edu.mum.domain.OrderStatus;
import edu.mum.domain.User;
import edu.mum.service.OrderService;

@Service
public class OrderServiceImpl implements OrderService{

	@Autowired
	private OrderDao orderRepository;

	@Override
	public void processOrder(Order order, OrderStatus orderStatus) {
		order.setOrderStatus(orderStatus);
		this.orderRepository.save(order);
	}

	@Override
	public List<Order> getOrderByUser(User user) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<Order> getAll() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Order save(Order order) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<Order> getOrdersByStatus(OrderStatus status) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Order findPropertyById(Long id) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Order findPropertyByNumber(String orderNumber) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void delete(Long id) {
		// TODO Auto-generated method stub
		
	}
	
//	public void processOrder(String productId, long quantity) {
//		Menu productById = productRepository.getProductByProductId(productId);
//		
// //		productById.setUnitsInStock(productById.getUnitsInStock() - quantity);
//	}
}
