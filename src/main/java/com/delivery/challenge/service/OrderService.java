package com.delivery.challenge.service;

import java.util.Collection;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import com.delivery.challenge.model.TypeStatus;
import com.delivery.challenge.model.Order;
import com.delivery.challenge.model.OrderItem;
import com.delivery.challenge.service.OrderService;
import com.delivery.challenge.repositary.OrderRepository;
@Service
public class OrderService  {

	
	@Autowired
	private OrderRepository orderRepository;
	
	
	public List<Order> listOrders() {
		return orderRepository.findAll();
	}
	
	
	public Optional<Order> findOrderById(Long id) {
		return orderRepository.findById(id);
	}

	
	public Order insertNewOrder(Order order) {
		System.out.println("Order :"+order.getOrderItems());
		return orderRepository.save(order);
	}

	
	public ResponseEntity<Order> cancelOrder(Long id) {

		
		Optional<Order> orderDb = orderRepository.findById(id);
		
		if (orderDb == null) {
			return ResponseEntity.notFound().build();
		}
		
		orderDb.get().setOrderStatus(TypeStatus.CANCELED.getCode());
		
		Order order =orderRepository.save(orderDb.get());
		
		return ResponseEntity.ok(order);
	}


	public ResponseEntity<Collection<OrderItem>> findItensByOrderId(Long id) {
		
		Optional<Order> order = orderRepository.findById(id);

		if (order != null) {
			return new ResponseEntity<>(order.get().getOrderItems(), HttpStatus.OK);
		} else {
			return new ResponseEntity<>(null, HttpStatus.NOT_FOUND);
		}
	}

}