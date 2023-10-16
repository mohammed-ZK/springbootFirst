package com.example.tempcart.tempcart.service.Impl;

import java.util.List;

import org.springframework.stereotype.Service;

import com.example.tempcart.tempcart.entity.Consumer;
import com.example.tempcart.tempcart.repository.ConsumerRepository;
import com.example.tempcart.tempcart.service.ConsumerService;
@Service
public class ConsumerServiceImpl implements ConsumerService{

	private final ConsumerRepository consumerRepository;
	
	public ConsumerServiceImpl(ConsumerRepository consumerRepository) {
		super();
		this.consumerRepository = consumerRepository;
	}
	
	public ConsumerRepository getConsumerRepository() {
		return consumerRepository;
	}

	@Override
	public Consumer findById(Long id) {
		return consumerRepository.findById(id).orElse(null);
	}

	@Override
	public Consumer getById(Long id) {
		// TODO Auto-generated method stub
		return consumerRepository.getById(id);
	}
	
	@Override
	public List<Consumer> findAll() {
		return consumerRepository.findAll();
	}

	@Override
	public Consumer insert(Consumer entity) {
		return consumerRepository.save(entity);
	}

	@Override
	public Consumer update(Consumer entity) {
		Consumer consumer=consumerRepository.getById(entity.getId_consumer());
		consumer.setFirst_Name(entity.getFirst_Name());
		consumer.setLast_Name(entity.getLast_Name());
		consumer.setPassword(entity.getPassword());
		consumer.setCartses(entity.getCartses());
		return consumerRepository.save(consumer);
	}

	@Override
	public void deleteById(Long id) {
		consumerRepository.deleteById(id);
	}

}
