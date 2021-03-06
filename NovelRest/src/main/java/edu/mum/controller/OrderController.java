package edu.mum.controller;

import java.time.LocalDate;
import java.util.HashMap;
import java.util.List;

import javax.validation.Valid;

import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.ModelAndView;

import edu.mum.amqp.OrderMQService;
import edu.mum.domain.Orders;
import edu.mum.domain.OrderItem;
import edu.mum.domain.OrderStatus;
import edu.mum.domain.UserRole;
import edu.mum.service.OrderItemService;
import edu.mum.service.OrderService;

@RestController
@RequestMapping("/orders")
public class OrderController {
	
	@Autowired
	private OrderMQService orderMQService;

	@Autowired
	private OrderService orderService;

	@Autowired
	private OrderItemService orderItemService;

	@RequestMapping("")
	public List<Orders> list(Model model) {
		return orderService.getAll();
	}

	@RequestMapping("/{id}")
	public Orders getOrderById(@PathVariable("id") String orderNum) {

		return orderService.findOrderByNumber(orderNum);
	}

	@RequestMapping(value = "", method = RequestMethod.POST)
	@ResponseBody
	public ResponseEntity<HttpStatus> addNewOrder(@RequestBody List<OrderItem> orderItems) {
		try {
			Orders orderToBeAdded = new Orders();
			orderToBeAdded.setItems(orderItems);
			orderToBeAdded.setOrderNumber(edu.mum.utils.NumberGenerator.getTimeStamp());
			// orderToBeAdded.setUser();
			orderService.save(orderToBeAdded);
		} catch (Exception e) {
			return ResponseEntity.ok(HttpStatus.BAD_REQUEST);
		}
		return ResponseEntity.ok(HttpStatus.OK);
	}

	@RequestMapping(value = "", method = RequestMethod.PUT)
	@ResponseBody
	public ResponseEntity<HttpStatus> setOrderStatus(@RequestParam("action") OrderStatus orderStatus,
			@RequestParam("orderNumber") String orderNumber) {
		Orders tmpOrder = this.orderService.findOrderByNumber(orderNumber);
		tmpOrder.setOrderStatus(orderStatus);
		this.orderService.save(tmpOrder);
		if (orderStatus == OrderStatus.COMFIRMED)
				orderMQService.publish(UserRole.STUDENT, tmpOrder);
		if (orderStatus == OrderStatus.DELIVERED) {
			//Send mail
			
		}	
		
		return ResponseEntity.ok(HttpStatus.OK);
	}

	// Comment added
	@RequestMapping(value = "/report", method = RequestMethod.GET)
	public List<Orders> getReportByDate(@RequestParam("startDate") LocalDate startDate,
			@RequestParam("endDate") LocalDate endDate) {
		return this.orderService.reportOrderByDate(startDate, endDate);
	}
}
