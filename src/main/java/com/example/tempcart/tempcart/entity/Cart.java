package com.example.tempcart.tempcart.entity;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;


import jakarta.persistence.CascadeType;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToMany;

@Entity
public class Cart {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long idCart;
	
	@ManyToOne(cascade= {CascadeType.PERSIST,CascadeType.MERGE,
            CascadeType.DETACH,CascadeType.REFRESH})
    @JoinColumn(name="id_consumer")
	private Consumer consumer;
	
	private BigDecimal subtotal;
	
	@OneToMany(cascade= {CascadeType.PERSIST,CascadeType.MERGE,
            CascadeType.DETACH,CascadeType.REFRESH})
    @JoinColumn(name="idProduct")
	private List<Product> products = new ArrayList<Product>();

	public Cart() {
		super();
	}

	public Cart(Long idCart, Consumer consumer, BigDecimal subtotal,
			List<com.example.tempcart.tempcart.entity.Product> products) {
		super();
		this.idCart = idCart;
		this.consumer = consumer;
		this.subtotal = subtotal;
		this.products = products;
	}

	public Long getIdCart() {
		return idCart;
	}

	public void setIdCart(Long idCart) {
		this.idCart = idCart;
	}

	public Consumer getConsumer() {
		return consumer;
	}

	public void setConsumer(Consumer consumer) {
		this.consumer = consumer;
	}

	public BigDecimal getSubtotal() {
		return subtotal;
	}

	public void setSubtotal(BigDecimal subtotal) {
		this.subtotal = subtotal;
	}

	public List<Product> getProducts() {
		return products;
	}

	public void setProducts(List<Product> products) {
		this.products = products;
	}


}
