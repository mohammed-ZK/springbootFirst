package com.example.tempcart.tempcart.service.Impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.tempcart.tempcart.entity.Product;
import com.example.tempcart.tempcart.repository.ProductRepository;
import com.example.tempcart.tempcart.service.ProductService;

@Service
public class ProductServiceImpl implements ProductService {

	@Autowired
	private final ProductRepository productRepository;
	
	public ProductServiceImpl(ProductRepository productRepository) {
		super();
		this.productRepository = productRepository;
	}

	public ProductRepository getProductRepository() {
		return this.productRepository;
	}

	@Override
	public Product findById(Long id) {
		return productRepository.findById(id).orElse(null);
	}

	@Override
	public List<Product> findAll() {
		return productRepository.findAll();
	}

	@Override
	public Product insert(Product entity) {
		return productRepository.save(entity);
	}

	@Override
	public Product update(Product entity) {
		Product product = productRepository.getById(entity.getIdProduct());
		product.setDescription(entity.getDescription());
		product.setPrice(entity.getPrice());
		product.setCart(entity.getCart());
		return productRepository.save(product);
	}

	@Override
	public void deleteById(Long id) {
		productRepository.deleteById(id);
	}
}
