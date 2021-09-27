package com.shopping.entities;

import javax.persistence.Entity;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonIgnore;

import javax.persistence.Id;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.OneToOne;
import java.io.Serializable;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.FetchType;


@Entity
@Table(name="product")
// @NamedQuery(name="Product.findByCategory", query = "Select distinct p from Product p fetch join p.category c where c.categoryName = ?1")
public class Product implements Serializable{
	private static final long serialVersionUID = 1L;
	@Id
	@Column(name="productid")
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private int productId;
	
	@Column(name="name")
	private String productName;
	
	@Column(name="price")
	private double price;
	
	@Column(name="color")
	private String color;
	
	@Column(name="dimension")
	private String dimension;
	
	@Column(name="specification")
	private String specification;
	
	@Column(name="manufacturer")
	private String manufacturer;
	
	@Column(name="quantity")
	private int quantity;
	
	@OneToOne(cascade= CascadeType.ALL,fetch = FetchType.LAZY)
	@JoinColumn(name="catid")
	private Category category;
	
	@ManyToOne(cascade= CascadeType.ALL)
	@JoinColumn(name="cartid")
	private Cart cart;
	
	@ManyToOne(cascade= CascadeType.ALL)
	@JoinColumn(name="orderid")
	private Order order;
	
//	public Product(int productId, String productName, double price, String color, String dimension, String specification, String manufacture, int quantity) {
//		this.productId=productId;
//		this.productName=productName;
//		this.price=price;
//		this.color= color;
//		this.dimension=dimension;
//		this.specification=specification;
//		this.manufacturer=manufacturer;
//		this.quantity=quantity;
//	}

	public int getProductId() {
		return productId;
	}

	public void setProductId(int productId) {
		this.productId = productId;
	}

	public String getProductName() {
		return productName;
	}

	public void setProductName(String productName) {
		this.productName = productName;
	}

	public double getPrice() {
		return price;
	}

	public void setPrice(double price) {
		this.price = price;
	}

	public String getColor() {
		return color;
	}

	public void setColor(String color) {
		this.color = color;
	}

	public String getDimension() {
		return dimension;
	}

	public void setDimension(String dimension) {
		this.dimension = dimension;
	}

	public String getSpecification() {
		return specification;
	}

	public void setSpecification(String specification) {
		this.specification = specification;
	}

	public String getManufacturer() {
		return manufacturer;
	}

	public void setManufacturer(String manufacturer) {
		this.manufacturer = manufacturer;
	}

	public int getQuantity() {
		return quantity;
	}

	public void setQuantity(int quantity) {
		this.quantity = quantity;
	}

	public Category getCategory() {
		return category;
	}

	public void setCategory(Category category) {
		this.category = category;
	}

	public Cart getCart() {
		return cart;
	}

	public void setCart(Cart cart) {
		this.cart = cart;
	}
    @JsonIgnore
	public Order getOrder() {
		return order;
	}

	public void setOrder(Order order) {
		this.order = order;
	}

    
}
