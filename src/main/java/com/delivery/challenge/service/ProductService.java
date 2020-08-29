package com.delivery.challenge.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import com.delivery.challenge.model.Product;
import com.delivery.challenge.repositary.ProductRepository;
import com.delivery.challenge.service.ProductService;

@Service
public class ProductService{

	
	@Autowired
	private ProductRepository productRepository;
	

	public List<Product> listProducts() {
		return productRepository.findAll();
	}

	
	public Optional<Product> findProductById(Long id) {
		return productRepository.findById(id);
	}


	public Product insertNewProduct(Product product) {
		return productRepository.save(product);
	}

	public ResponseEntity<Product> updateProduct(Long id, Product product) {
		
		
		Optional<Product> productDb = productRepository.findById(id);
		
		if (productDb == null) {
			return ResponseEntity.notFound().build();
		}
		
		BeanUtils.copyProperties(product, productDb, "id");
		
		Product product1 = productRepository.save(productDb.get());
		
		return ResponseEntity.ok(product1);
		
	}

	
	public ResponseEntity<Void> removeProduct(Long id) {

		Optional<Product> product = productRepository.findById(id);
		
		if (product == null) {
			return ResponseEntity.notFound().build();
		}
		
		productRepository.delete(product.get());
		
		return ResponseEntity.noContent().build();
	}
}