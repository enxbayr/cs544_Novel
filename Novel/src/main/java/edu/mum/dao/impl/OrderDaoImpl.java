package edu.mum.dao.impl;

import java.time.LocalDate;
import java.util.List;

import javax.persistence.Query;

import org.springframework.stereotype.Repository;

import edu.mum.domain.User;
import edu.mum.domain.Order;
import edu.mum.domain.OrderStatus;
import edu.mum.dao.OrderDao;

@Repository
public class OrderDaoImpl extends GenericDaoImpl<Order> implements OrderDao {

	public OrderDaoImpl() {
		super.setDaoType(Order.class);
	}

	public Order getOrderById(Long id) {
		return this.getOrderById(id);
	}

	public Order getOrderByNumber(String orderNum) {
		Query query = entityManager.createQuery("select p from Order p  where p.orderNumber =:orderNumber");
		return (Order) query.setParameter("orderNumber", orderNum).getSingleResult();

	}

	@SuppressWarnings("unchecked")
	public List<Order> getOrderByStatus(OrderStatus orderStat) {

		Query query = entityManager.createQuery("select p from Order p where p.orderStatus = :orderStatus");

		return (List<Order>) query.setParameter("orderStatus", orderStat).getResultList();
	}

	@SuppressWarnings("unchecked")
	public List<Order> getOrdersByUser(User user) {

		Query query = entityManager.createQuery("select p from Order p where p.user = :user");

		return (List<Order>) query.setParameter("user", user).getResultList();
	}

	@SuppressWarnings("unchecked")
	public List<Order> getOrdersByDate(LocalDate startDate, LocalDate endDate) {
		Query query = entityManager
				.createQuery("select p from Order p where p.orderDate between :beginDate and :endDate");
		query.setParameter("startDate", startDate);
		query.setParameter("endDate", endDate);

		return (List<Order>) query.getResultList();
	}

}
