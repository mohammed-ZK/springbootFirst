package com.example.tempcart.tempcart.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.example.tempcart.tempcart.entity.Consumer;


@Repository
public interface ConsumerRepository extends JpaRepository<Consumer, Long> {

}
