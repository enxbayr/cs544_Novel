package edu.mum.domain;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.persistence.Version;

@Entity
@Table(name = "Order")
public class Order {
	  @Id
	   @GeneratedValue(strategy = GenerationType.IDENTITY)
	   @Column(name = "id", updatable = false, nullable = false)
	   private Long id = null;
	   @Version
	   @Column(name = "version")
	   private int version = 0;

	   @Column
	   private String orderNumber;
	   
	   public OrderStatus getOrderStatus() {
		return orderStatus;
	}

	public LocalDate getOrderDate() {
		return orderDate;
	}

	public void setOrderStatus(OrderStatus orderStatus) {
		this.orderStatus = orderStatus;
	}

	public void setOrderDate(LocalDate orderDate) {
		this.orderDate = orderDate;
	}

	@Column
	   private OrderStatus orderStatus;
	   
	   @Column
	   private LocalDate orderDate;
	   
	   @Column
	   @ManyToOne(fetch = FetchType.LAZY, cascade = { CascadeType.PERSIST, CascadeType.MERGE })
	   private User user;

	   @OneToMany(mappedBy = "order", fetch = FetchType.LAZY, cascade = { CascadeType.PERSIST, CascadeType.MERGE })
	   private List<OrderItem> items = new ArrayList<OrderItem>();

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public int getVersion() {
		return version;
	}

	public void setVersion(int version) {
		this.version = version;
	}

	public String getOrderNumber() {
		return orderNumber;
	}

	public void setOrderNumber(String orderNumber) {
		this.orderNumber = orderNumber;
	}

	public List<OrderItem> getItems() {
		return items;
	}

	public void setItems(List<OrderItem> items) {
		this.items = items;
	}
	
	public void addOrderItem(OrderItem orderItem) {
		this.items.add(orderItem);
		orderItem.setOrder(this);
	}

	public User getUser() {
		return user;
	}

	public void setUser(User user) {
		this.user = user;
	}

}
