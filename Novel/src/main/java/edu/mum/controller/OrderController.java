package edu.mum.controller;

import java.util.HashMap;
import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.ModelAndView;

import edu.mum.domain.Menu;
import edu.mum.domain.Order;
import edu.mum.domain.OrderItem;
import edu.mum.service.OrderItemService;
import edu.mum.service.OrderService;

@RestController
@RequestMapping("/orders")
public class OrderController {
	
<<<<<<< HEAD
	@Autowired
	private OrderService orderService;
	
	@Autowired
	private OrderItemService orderItemService;
 
 	@RequestMapping("")
	public List<Order> list(Model model) {
		return  orderService.getAll();
	}
=======
>>>>>>> branch 'master' of https://github.com/enxbayr/cs544_Novel.git
	
<<<<<<< HEAD
 	@RequestMapping("/{id}")
	public Order getOrderById( @PathVariable("id") String orderNum) {

		return orderService.findOrderByNumber(orderNum);
 	}
	   
	@RequestMapping(value = "", method = RequestMethod.POST)
	@ResponseStatus(value = HttpStatus.NO_CONTENT)
	public void addNewOrder(@RequestBody List<OrderItem> orderItems) {
			Order orderToBeAdded = new Order();
			orderToBeAdded.setItems(orderItems);
			orderToBeAdded.setOrderNumber(edu.mum.utils.NumberGenerator.getTimeStamp());
			orderToBeAdded.setUser(user);
			
			orderService.save(orderToBeAdded);
 
	}
=======
>>>>>>> branch 'master' of https://github.com/enxbayr/cs544_Novel.git
	
   
}
