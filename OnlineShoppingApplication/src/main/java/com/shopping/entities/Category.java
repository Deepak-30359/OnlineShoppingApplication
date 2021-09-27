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
@Entity
@Table(name="category")
public class Category implements Serializable{
	private static final long serialVersionUID = 1L;
	@Id
	@Column(name="catid")
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private int catId;
	
	@Column(name="name")
	private String categoryName;
	
	@OneToOne(mappedBy="category",cascade = CascadeType.ALL)
    private Product product;

	public int getCatId() {
		return catId;
	}

	public void setCatId(int catId) {
		this.catId = catId;
	}

	public String getCategoryName() {
		return categoryName;
	}

	public void setCategoryName(String categoryName) {
		this.categoryName = categoryName;
	}
    @JsonIgnore
	public Product getProduct() {
		return product;
	}

	public void setProduct(Product product) {
		this.product = product;
	}

	
}
