package com.delivery.challenge.controller;

import java.util.Collection;
import java.util.List;
import java.util.Optional;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.delivery.challenge.model.Order;
import com.delivery.challenge.model.OrderItem;
import com.delivery.challenge.service.OrderService;

@RestController
@RequestMapping("/order")
public class OrderController {
	
	
	@Autowired
	private OrderService orderService;
	
	@GetMapping("/all")
	public List<Order> list(){
		return orderService.listOrders();
	}
	
	@GetMapping ("{id}")
	public Optional<Order> findById(@PathVariable Long id) {
		return orderService.findOrderById(id);
	}
	
	@GetMapping ("/{id}/items")
	public ResponseEntity<Collection<OrderItem>> findProductsByOrderId(@PathVariable Long id) {
		return orderService.findItensByOrderId(id);
	}
	
	public Order insert(@Valid @RequestBody Order order,@PathVariable Long id) {
		System.out.println("Inside order ");
		order.setResturantId(id);
		return orderService.insertNewOrder(order);
	}
	
	@PutMapping("/{id}")
	public ResponseEntity<Order> cancel(@PathVariable Long id) {
		return orderService.cancelOrder(id);
	}

}