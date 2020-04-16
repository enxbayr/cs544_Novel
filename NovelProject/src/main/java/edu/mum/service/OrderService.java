package edu.mum.service;

import java.time.LocalDate;
import java.util.List;
import edu.mum.domain.Orders;
import edu.mum.domain.OrderStatus;
import edu.mum.domain.Member;

public interface OrderService {
	public void setOrderStatus(String orderNum, OrderStatus orderStatus);
	public List<Orders> getOrderByUser(Member member);
	public List<Orders> getAll();
	public void save(Orders order);	
	public List<Orders> getOrdersByStatus(OrderStatus status);
	public Orders findOrderById(Long id);
	public Orders findOrderByNumber(String orderNumber);
	public void delete(Long id);
	public List<Orders> reportOrderByDate(LocalDate startDate, LocalDate endDate);
}
