package edu.mum.dao.impl;

import java.time.LocalDate;
import java.util.List;

import javax.persistence.Query;

import org.springframework.stereotype.Repository;

import edu.mum.domain.Member;
import edu.mum.domain.Orders;
import edu.mum.domain.OrderStatus;
import edu.mum.dao.OrderDao;

@Repository
public class OrderDaoImpl extends GenericDaoImpl<Orders> implements OrderDao {

	public OrderDaoImpl() {
		super.setDaoType(Orders.class);
	}

	public Orders getOrderById(Long id) {
		return this.getOrderById(id);
	}

	public Orders getOrderByNumber(String orderNum) {
		Query query = entityManager.createQuery("select p from Order p  where p.orderNumber =:orderNumber");
		return (Orders) query.setParameter("orderNumber", orderNum).getSingleResult();

	}

	@SuppressWarnings("unchecked")
	public List<Orders> getOrderByStatus(OrderStatus orderStat) {

		Query query = entityManager.createQuery("select p from Order p where p.orderStatus = :orderStatus");

		return (List<Orders>) query.setParameter("orderStatus", orderStat).getResultList();
	}

	@SuppressWarnings("unchecked")
	public List<Orders> getOrdersByUser(Member user) {

		Query query = entityManager.createQuery("select p from Order p where p.user = :user");

		return (List<Orders>) query.setParameter("user", user).getResultList();
	}

	@SuppressWarnings("unchecked")
	public List<Orders> getOrdersByDate(LocalDate startDate, LocalDate endDate) {
		Query query = entityManager
				.createQuery("select p from Order p where p.orderDate between :beginDate and :endDate");
		query.setParameter("startDate", startDate);
		query.setParameter("endDate", endDate);

		return (List<Orders>) query.getResultList();
	}

}
