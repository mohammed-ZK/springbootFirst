package com.example.tempcart.tempcart.controller;

import java.util.List;

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

import com.example.tempcart.tempcart.entity.Cart;
import com.example.tempcart.tempcart.service.CartService;

@RestController
@RequestMapping("/api/carts")
public class CartController {
	@Autowired
	private final CartService cartService;
	
	public CartController(CartService cartService) {
		super();
		this.cartService = cartService;
	}
	
	@GetMapping("/{id}")
	public ResponseEntity<Cart> findById(@PathVariable Long id) {
		Cart cart = cartService.findById(id);
		return ResponseEntity.ok(cart);
	}

	@GetMapping()
	public ResponseEntity<List<Cart>> findAll() {
		List<Cart> carts = cartService.findAll();
		return ResponseEntity.ok(carts);
	}

	@PostMapping()
	public ResponseEntity<Cart> insert(@RequestBody Cart entity) {
		Cart cart = cartService.insert(entity);
		return ResponseEntity.ok(cart);
	}

	@PutMapping("/{id}")
	public ResponseEntity<Cart> update(@PathVariable Long id, @RequestBody Cart entity) {
		Cart cart = cartService.findById(id);
		cart.setConsumer(entity.getConsumer());
		cart.setSubtotal(entity.getSubtotal());
		cartService.update(cart);
		return ResponseEntity.ok(cart);
	}

	@DeleteMapping("/{id}")
	public void deleteById(@PathVariable Long id) {
		cartService.deleteById(id);
//		return ResponseEntity.ok(id);
	}
}
