package com.delivery.challenge.controller;

import java.util.List;
import java.util.Optional;

import javax.validation.Valid;
import javax.ws.rs.Path;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.delivery.challenge.model.Order;
import com.delivery.challenge.model.Product;
import com.delivery.challenge.model.Restaurant;
import com.delivery.challenge.service.OrderService;
import com.delivery.challenge.service.ResturantService;

@RestController
@RequestMapping("/restaurant")
public class RestaurantController {
	
	
	@Autowired
	private ResturantService restaurantService;
	@Autowired
	private OrderController orderController;
	
	@GetMapping("/all")
	public List<Restaurant> list(){
		return restaurantService.listRestaurants();
	}
	
	@GetMapping ("{id}")
	public Optional<Restaurant> findById(@PathVariable Long id) {
		return restaurantService.findRestaurantById(id);
	}
	
	@PostMapping
	public Restaurant insert(@Valid @RequestBody Restaurant restaurant) {
		return restaurantService.insertNewRestaurant(restaurant);
	}
	
	@PutMapping("/{id}")
	public ResponseEntity<Restaurant> update(@PathVariable Long id, 
			@Valid @RequestBody Restaurant restaurant) {
		
		return restaurantService.updateRestaurant(id, restaurant);
	}
	
	@DeleteMapping("/{id}")
	public ResponseEntity<Void> remove(@PathVariable Long id) {
		return restaurantService.removeRestaurant(id);
	}
	@GetMapping("/{id}/products")
	public List<Product> getProductController(@PathVariable Long id) {
		return restaurantService.getProducts(id);
	}
	@PostMapping("/{id}/order")
	public Order insert(@Valid @RequestBody Order order,@PathVariable Long id) {
		System.out.println("Inside res order");
		return orderController.insert(order, id);
	}

}