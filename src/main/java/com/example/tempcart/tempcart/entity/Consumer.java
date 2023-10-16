package com.example.tempcart.tempcart.entity;

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
public class Consumer {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private long id_consumer;
	private String first_Name;
	private String last_Name;
	private String password;
	@OneToMany(cascade= {CascadeType.PERSIST,CascadeType.MERGE,
            CascadeType.DETACH,CascadeType.REFRESH})
    @JoinColumn(name="idCart")
	private List<Cart> cartses = new ArrayList<Cart>();

	public Consumer() {
		super();
	}

	public Consumer(long id_consumer, String first_Name, String last_Name, String password,
			List<com.example.tempcart.tempcart.entity.Cart> cartses) {
		super();
		this.id_consumer = id_consumer;
		this.first_Name = first_Name;
		this.last_Name = last_Name;
		this.password = password;
		this.cartses = cartses;
	}

	public long getId_consumer() {
		return id_consumer;
	}

	public void setId_consumer(long id_consumer) {
		this.id_consumer = id_consumer;
	}

	public String getFirst_Name() {
		return first_Name;
	}

	public void setFirst_Name(String first_Name) {
		this.first_Name = first_Name;
	}

	public String getLast_Name() {
		return last_Name;
	}

	public void setLast_Name(String last_Name) {
		this.last_Name = last_Name;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public List<Cart> getCartses() {
		return cartses;
	}

	public void setCartses(List<Cart> cartses) {
		this.cartses = cartses;
	}

}

