package com.example.tempcart.tempcart.service;

import java.util.List;

import com.example.tempcart.tempcart.entity.Consumer;

public interface ConsumerService {

	Consumer findById(Long id);

	Consumer getById(Long id);

	List<Consumer> findAll();

	Consumer insert(Consumer entity);

	Consumer update(Consumer entity);

	void deleteById(Long id);

}
