package edu.mum.dao.impl;

import java.util.List;

import javax.persistence.Query;
import org.springframework.stereotype.Repository;
import edu.mum.domain.Order;
import edu.mum.domain.OrderItem;
import edu.mum.dao.OrderItemDao;

@Repository
public class OrderItemDaoImpl extends GenericDaoImpl<OrderItem> implements OrderItemDao {

	public OrderItemDaoImpl() {
		super.setDaoType(OrderItem.class);
	}

	public OrderItem getOrderById(Long id) {
		return this.getOrderById(id);
	}

	@SuppressWarnings("unchecked")
	public List<OrderItem> getOrderItemByOrder(Order order) {
		Query query = entityManager.createQuery("select p from OrderItem p where p.order = :order");
		return (List<OrderItem>) query.setParameter("order", order).getResultList();
	}
}
