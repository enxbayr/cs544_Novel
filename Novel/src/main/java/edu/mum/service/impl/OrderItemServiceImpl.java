package edu.mum.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import edu.mum.dao.OrderDao;
import edu.mum.domain.Menu;
import edu.mum.service.OrderService;

@Service
public class OrderItemServiceImpl implements OrderService{

	@Autowired
	private OrderDao productRepository;
	
	public void processOrder(String productId, long quantity) {
		Menu productById = productRepository.getProductByProductId(productId);
		
 //		productById.setUnitsInStock(productById.getUnitsInStock() - quantity);
	}
}
