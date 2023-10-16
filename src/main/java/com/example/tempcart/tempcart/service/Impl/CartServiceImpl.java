package com.example.tempcart.tempcart.service.Impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.tempcart.tempcart.entity.Cart;
import com.example.tempcart.tempcart.repository.CartRepository;
import com.example.tempcart.tempcart.service.CartService;

@Service
public class CartServiceImpl implements CartService {

	@Autowired
	private final CartRepository cartRepository;
	
	public CartServiceImpl(CartRepository cartRepository) {
		super();
		this.cartRepository = cartRepository;
	}

	public CartRepository getCartRepository() {
		return this.cartRepository;
	}

	@Override
	public Cart findById(Long id) {
		return cartRepository.findById(id).orElse(null);
	}

	@Override
	public List<Cart> findAll() {
		return cartRepository.findAll();
	}

	@Override
	public Cart insert(Cart entity) {
		// TODO Auto-generated method stub
		return cartRepository.save(entity);
	}

	@Override
	public Cart update(Cart entity) {
		Cart cart=cartRepository.getById(entity.getIdCart());
		cart.setConsumer(entity.getConsumer());
		cart.setSubtotal(entity.getSubtotal());
		cart.setProducts(entity.getProducts());
		return cartRepository.save(cart);
	}

	@Override
	public void deleteById(Long id) {
		// TODO Auto-generated method stub
		cartRepository.deleteById(id);
	}
}
