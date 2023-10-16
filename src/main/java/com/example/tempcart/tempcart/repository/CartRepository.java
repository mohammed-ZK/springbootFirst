package com.example.tempcart.tempcart.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.example.tempcart.tempcart.entity.Cart;


@Repository
public interface CartRepository extends JpaRepository<Cart, Long> {

}
