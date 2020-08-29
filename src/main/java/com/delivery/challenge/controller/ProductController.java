package com.delivery.challenge.controller;

import java.util.List;
import java.util.Optional;

import javax.validation.Valid;


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

import com.delivery.challenge.model.Product;
import com.delivery.challenge.service.ProductService;

@RestController
@RequestMapping("/product")
public class ProductController {
	
	
	@Autowired
	private ProductService productService;
	
	@GetMapping("/all")
	public List<Product> list(){
		return productService.listProducts();
	}
	
	@GetMapping ("{id}")
	public Optional<Product> findById(@PathVariable Long id) {
		return productService.findProductById(id);
	}
	
	@PostMapping
	public Product insert(@Valid @RequestBody Product product) {
		return productService.insertNewProduct(product);
	}
	
	@PutMapping("/{id}")
	public ResponseEntity<Product> update(@PathVariable Long id, 
			@Valid @RequestBody Product product) {
		
		return productService.updateProduct(id, product);
	}
	
	@DeleteMapping("/{id}")
	public ResponseEntity<Void> remove(@PathVariable Long id) {
		return productService.removeProduct(id);
	}

}