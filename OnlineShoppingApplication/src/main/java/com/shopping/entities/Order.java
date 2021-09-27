package com.shopping.entities;

import java.io.Serializable;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import java.time.LocalDate;
import javax.persistence.CascadeType;
import javax.persistence.JoinColumn;
import javax.persistence.FetchType;
import java.util.HashSet;
import java.util.Set;
 

@Entity
@Table(name="order_mast")
//@NamedQuery(name="Order.findByLocation", query = "Select orderid from order_mast o, address a where order_mast.addressid = a.addressid and a.pin = :pin")
//@NamedQuery(name="order.findByUserId", query = "select o from order_mast o where o.orderid in (select u.userid from user_mast u where u.userid = o.orderid)")
public class Order implements Serializable{
	private static final long serialVersionUID = 1L;
	@Id
	@Column(name="orderid")
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private int orderId;
	
	@Column(name="date")
	private LocalDate orderDate;
	
	@Column(name="orderstatus")
	private String orderStatus;
	
	@ManyToOne(cascade = CascadeType.ALL, fetch = FetchType.LAZY)
	@JoinColumn(name = "addressid",nullable = false)
	private Address address;
	
	@ManyToOne(cascade = CascadeType.ALL, fetch = FetchType.LAZY)
	@JoinColumn(name = "customerid", nullable = false)
	private Customer customer;
	
	@OneToMany(mappedBy="order")
	private Set<Product> productlist = new HashSet<>();
	
//	public Order(int orderId, String orderStatus) {
//		this.orderId=orderId;
//		//this.orderDate=orderDate;
//		this.orderStatus=orderStatus;
//	}

	public int getOrderId() {
		return orderId;
	}

	public void setOrderId(int orderId) {
		this.orderId = orderId;
	}

	public LocalDate getOrderDate() {
		return orderDate;
	}

	public void setOrderDate(LocalDate orderDate) {
		this.orderDate = orderDate;
	}

	public String getOrderStatus() {
		return orderStatus;
	}

	public void setOrderStatus(String orderStatus) {
		this.orderStatus = orderStatus;
	}

	public Address getAddress() {
		return address;
	}

	public void setAddress(Address address) {
		this.address = address;
	}

	public Customer getCustomer() {
		return customer;
	}

	public void setCustomer(Customer customer) {
		this.customer = customer;
	}

	public Set<Product> getProductlist() {
		return productlist;
	}

	public void setProductlist(Set<Product> productlist) {
		this.productlist = productlist;
	}

	
}
