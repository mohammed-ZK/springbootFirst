package com.example.tempcart.tempcart.service;

import java.util.List;

import com.example.tempcart.tempcart.entity.Cart;


public interface CartService {
	Cart findById(Long id);

	List<Cart> findAll();

	Cart insert(Cart entity);

	Cart update(Cart entity);

	void deleteById(Long id);
}
