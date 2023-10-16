package com.example.tempcart.tempcart.service;

import java.util.List;

import com.example.tempcart.tempcart.entity.Product;

public interface ProductService {
	Product findById(Long id);

	List<Product> findAll();

	Product insert(Product entity);

	Product update(Product entity);

	void deleteById(Long id);
}
