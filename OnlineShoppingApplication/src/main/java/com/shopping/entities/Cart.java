package com.shopping.entities;

import java.io.Serializable;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import java.util.Set;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.Table;
import javax.persistence.OneToMany;
import java.util.HashSet;
@Entity
@Table(name="cart")
public class Cart implements Serializable{
	private static final long serialVersionUID = 1L;
	@Id
	@Column(name="cartid")
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private int cartId;
	
	@OneToOne(cascade = CascadeType.ALL, fetch = FetchType.LAZY)
	@JoinColumn(name="customerid")
	private Customer customer;
	
	@OneToMany(mappedBy="cart")
	private Set<Product> products = new HashSet<>();
	
//	String productName; 
//	int quantity;
	
	public Cart(int cartId) {
		this.cartId=cartId;
	}
//	public Cart(int cartId, String productName, int quantity) {
//		this.cartId=cartId;
//		this.productName=productName;
//		this.quantity=quantity;
//	}

	public int getCartId() {
		return cartId;
	}

	public void setCartId(int cartId) {
		this.cartId = cartId;
	}

	public Customer getCustomer() {
		return customer;
	}

	public void setCustomer(Customer customer) {
		this.customer = customer;
	}

	public Set<Product> getProducts() {
		return products;
	}

	public void setProducts(Set<Product> products) {
		this.products = products;
	}

	
}