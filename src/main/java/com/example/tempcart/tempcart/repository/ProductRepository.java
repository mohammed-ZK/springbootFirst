package com.example.tempcart.tempcart.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.tempcart.tempcart.entity.Product;


public interface ProductRepository extends JpaRepository<Product, Long> {

}
