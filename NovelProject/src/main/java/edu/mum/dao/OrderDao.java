package edu.mum.dao;

import java.time.LocalDate;
import java.util.List;
import edu.mum.domain.Orders;
import edu.mum.domain.Member;
import edu.mum.domain.OrderStatus;

public interface OrderDao extends GenericDao<Orders> {
	public Orders getOrderById(Long id);

	public Orders getOrderByNumber(String orderNum);

	public List<Orders> getOrderByStatus(OrderStatus orderStatus);

	public List<Orders> getOrdersByDate(LocalDate startDate, LocalDate endDate);

	public List<Orders> getOrdersByMember(Member user);
}
