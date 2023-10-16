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

import com.example.tempcart.tempcart.entity.Consumer;
import com.example.tempcart.tempcart.repository.ConsumerRepository;
import com.example.tempcart.tempcart.service.ConsumerService;


@RestController
@RequestMapping("/consumer")
public class ConsumerController {

	@Autowired
	private final ConsumerService consumerService;

	public ConsumerController(ConsumerService consumerService) {
		super();
		this.consumerService = consumerService;
	}

	@GetMapping("/{id}")
	public ResponseEntity<Consumer> findById(@PathVariable Long id) {
		Consumer consumer = consumerService.findById(id);
		return ResponseEntity.ok(consumer);
	}

	@GetMapping()
	public ResponseEntity<List<Consumer>> findAll() {
		List<Consumer> consumers = consumerService.findAll();
		return ResponseEntity.ok(consumers);
	}

	@PostMapping()
	public ResponseEntity<Consumer> insert(@RequestBody Consumer entity) {
		Consumer consumer = consumerService.insert(entity);
		return ResponseEntity.ok(consumer);
	}

	@PutMapping("/{id}")
	public ResponseEntity<Consumer> update(@PathVariable Long id,@RequestBody Consumer entity) {
		Consumer consumer = consumerService.findById(id);
//		Consumer consumer = new Consumer();
		consumer.setFirst_Name(entity.getFirst_Name());
		consumer.setLast_Name(entity.getLast_Name());
		consumer.setPassword(entity.getPassword());
		consumer.setCartses(entity.getCartses());
		consumerService.update(consumer);
		return ResponseEntity.ok(consumer);
	}

	@DeleteMapping("/{id}")
	public void deleteById(@PathVariable Long id) {
		consumerService.deleteById(id);
//		return ResponseEntity.ok(null);
	}
}
