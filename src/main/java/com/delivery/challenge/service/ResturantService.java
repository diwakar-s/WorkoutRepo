package com.delivery.challenge.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import com.delivery.challenge.model.Order;
import com.delivery.challenge.model.Product;
import com.delivery.challenge.model.Restaurant;
import com.delivery.challenge.repositary.ProductRepository;
import com.delivery.challenge.repositary.RestaurantRepository;

@Service
public class ResturantService{

	
	@Autowired
	private RestaurantRepository restaurantRepository;
	@Autowired
	private ProductRepository productRepository;

	public List<Restaurant> listRestaurants() {
		return restaurantRepository.findAll();
	}


	public Optional<Restaurant> findRestaurantById(Long id) {
		return restaurantRepository.findById(id);
	}

	public Restaurant insertNewRestaurant(Restaurant restaurant) {
		return restaurantRepository.save(restaurant);
	}

	public ResponseEntity<Restaurant> updateRestaurant(Long id, Restaurant restaurant) {
		
		
		Optional<Restaurant> restaurantDb = restaurantRepository.findById(id);
		
		if (restaurantDb == null) {
			return ResponseEntity.notFound().build();
		}
		
		BeanUtils.copyProperties(restaurant, restaurantDb, "id");
		
		Restaurant restaurantObj = restaurantRepository.save(restaurantDb.get());
		
		return ResponseEntity.ok(restaurantObj);
		
	}

	
	public ResponseEntity<Void> removeRestaurant(Long id) {

		Optional<Restaurant> restaurant = restaurantRepository.findById(id);
		
		if (restaurant == null) {
			return ResponseEntity.notFound().build();
		}
		
		restaurantRepository.delete(restaurant.get());
		
		return ResponseEntity.noContent().build();
	}
	public List<Product> getProducts(Long id){
		System.out.println("Id "+id);
		System.out.println("Id "+productRepository);
		return (List<Product>) productRepository.findByrestaurantId(id);
						
	}
}