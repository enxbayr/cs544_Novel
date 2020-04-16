package edu.mum.service.impl;

import java.time.LocalDate;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import edu.mum.dao.OrderDao;
import edu.mum.domain.Orders;
import edu.mum.domain.OrderStatus;
import edu.mum.domain.User;
import edu.mum.service.OrderService;

@Service
public class OrderServiceImpl implements OrderService{

	@Autowired
	private OrderDao orderRepository;

	@Override
	public void setOrderStatus(String orderNum, OrderStatus orderStatus) {
		Orders order = this.orderRepository.getOrderByNumber(orderNum);
		order.setOrderStatus(orderStatus);
		this.orderRepository.save(order);
	}

	@Override
	public List<Orders> getOrderByUser(User user) {
		return this.orderRepository.getOrdersByUser(user);
	}

	@Override
	public List<Orders> getAll() {
		return this.orderRepository.findAll();
	}

	@Override
	public void save(Orders order) {
		this.orderRepository.save(order);;
	}

	@Override
	public List<Orders> getOrdersByStatus(OrderStatus status) {
		return this.orderRepository.getOrderByStatus(status);
	}

	@Override
	public Orders findOrderById(Long id) {
		return this.orderRepository.getOrderById(id);
	}

	@Override
	public Orders findOrderByNumber(String orderNumber) {
		return this.orderRepository.getOrderByNumber(orderNumber);
	}

	@Override
	public void delete(Long id) {
		this.orderRepository.delete(id);
	}

	@Override
	public List<Orders> reportOrderByDate(LocalDate startDate, LocalDate endDate) {
		return this.orderRepository.getOrdersByDate(startDate, endDate);
	}
}
