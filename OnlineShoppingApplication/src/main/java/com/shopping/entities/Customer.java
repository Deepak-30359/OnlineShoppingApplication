package com.shopping.entities;

import java.io.Serializable;
import java.util.HashSet;
import java.util.Set;
import javax.persistence.FetchType;
import javax.persistence.Column;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.Entity;
import javax.persistence.Table;
import javax.persistence.CascadeType;

@Entity
@Table(name="customer_master")
public class Customer implements Serializable{
	private static final long serialVersionUID = 1L;
	@Id
	@Column(name = "customerid")
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private int customerId;
	
	@Column(name="firstname")
	private String firstName;
	@Column(name="lastname")
	private String lastName;
	@Column(name="mobilenumber")
	private String mobileNumber;
	@Column(name="email")
	private String email;
	
	@OneToOne(mappedBy="customer",cascade = CascadeType.ALL)
	private Address address;
	
	@OneToMany(mappedBy = "customer", cascade= CascadeType.ALL)
	private Set<Order> order = new HashSet<>();
	
	@OneToOne(mappedBy="customer",cascade= CascadeType.ALL)
	private Cart cart;
	
	@OneToOne(cascade = CascadeType.ALL, fetch = FetchType.LAZY)
	@JoinColumn(name="userid")
	private User user;
	
//	String location;
//	public Customer(int customerId, String firstName, String lastName, String mobileNumber, String email, String location) {
//		this.customerId=customerId;
//		this.firstName=firstName;
//		this.lastName=lastName;
//		this.mobileNumber= mobileNumber;
//		this.email=email;
//		this.location=location;
//	}

	public int getCustomerId() {
		return customerId;
	}

	public void setCustomerId(int customerId) {
		this.customerId = customerId;
	}

	public String getFirstName() {
		return firstName;
	}

	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}

	public String getLastName() {
		return lastName;
	}

	public void setLastName(String lastName) {
		this.lastName = lastName;
	}

	public String getMobileNumber() {
		return mobileNumber;
	}

	public void setMobileNumber(String mobileNumber) {
		this.mobileNumber = mobileNumber;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public Address getAddress() {
		return address;
	}

	public void setAddress(Address address) {
		this.address = address;
	}

	public Set<Order> getOrder() {
		return order;
	}

	public void setOrder(Set<Order> order) {
		this.order = order;
	}
    
	public Cart getCart() {
		return cart;
	}

	public void setCart(Cart cart) {
		this.cart = cart;
	}

	public User getUser() {
		return user;
	}

	public void setUser(User user) {
		this.user = user;
	}
}