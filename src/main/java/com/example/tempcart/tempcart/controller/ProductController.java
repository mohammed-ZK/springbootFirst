package com.example.tempcart.tempcart.controller;

import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.tempcart.tempcart.entity.Product;
import com.example.tempcart.tempcart.service.ProductService;



@RestController
@RequestMapping("/products")
public class ProductController {
	@Autowired
	private final ProductService productService;
	
	public ProductController(ProductService productService) {
		super();
		this.productService = productService;
	}

	@GetMapping("/{id}")
	public ResponseEntity<Product> findById(@PathVariable Long id) {
		Product product = productService.findById(id);
		return ResponseEntity.ok(product);
	}

	@GetMapping()
	public ResponseEntity<List<Product>> findAll() {
		List<Product> products = productService.findAll();
		return ResponseEntity.ok(products);
	}

	@PostMapping()
	public ResponseEntity<Product> insert(@RequestBody Product entity) {
		Product product = productService.insert(entity);
		return ResponseEntity.ok(product);
	}

	@PutMapping("/{id}")
	public ResponseEntity<Product> update(@PathVariable Long id,  @RequestBody Product entity) {
		Product product = productService.findById(id);
		product.setDescription(entity.getDescription());
		product.setCart(entity.getCart());
		product.setPrice(entity.getPrice());
		productService.update(product);
		return ResponseEntity.ok(product);
	}

	@DeleteMapping("/{id}")
	public ResponseEntity<?> deleteById(@PathVariable Long id) {
		productService.deleteById(id);
		return ResponseEntity.ok(id);
	}
	
}
