package com.shopping.entities;

import java.io.Serializable;
import java.util.HashSet;
import java.util.Set;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.Table;


@Entity
@Table(name="address_master")
public class Address implements Serializable{
	private static final long serialVersionUID = 1L;
	@Id
	@Column(name = "addressid")
	@GeneratedValue(strategy=GenerationType.IDENTITY)
     private int addressId;
	
	@Column(name="streetno")
	private String streetNo;
	
	@Column(name="buildingname")
	private String buildingName;
	
	@Column(name="city")
	private String City;
	
	@Column(name="state")
	private String State;
	
	@Column(name="country")
	private String Country;
	
	@Column(name="pincode")
	private String pincode;
	
	@OneToOne(cascade= CascadeType.ALL, fetch = FetchType.LAZY)
	@JoinColumn(name="customerid")
	private Customer customer;
	
	@OneToMany(mappedBy = "address", cascade= CascadeType.ALL)
	private Set<Order> order = new HashSet<>();
	
//	public Address(int addressId, String streetNo, String buildingName, String City, String State, String Country, String pincode) {
//		this.addressId=addressId;
//		this.streetNo=streetNo;
//		this.buildingName=buildingName;
//		this.City= City;
//		this.State=State;
//		this.Country=Country;
//		this.pincode=pincode;
//	
//		}

	public int getAddressId() {
		return addressId;
	}

	public void setAddressId(int addressId) {
		this.addressId = addressId;
	}

	public String getStreetNo() {
		return streetNo;
	}

	public void setStreetNo(String streetNo) {
		this.streetNo = streetNo;
	}

	public String getBuildingName() {
		return buildingName;
	}

	public void setBuildingName(String buildingName) {
		this.buildingName = buildingName;
	}

	public String getCity() {
		return City;
	}

	public void setCity(String city) {
		City = city;
	}

	public String getState() {
		return State;
	}

	public void setState(String state) {
		State = state;
	}

	public String getCountry() {
		return Country;
	}

	public void setCountry(String country) {
		Country = country;
	}

	public String getPincode() {
		return pincode;
	}

	public void setPincode(String pincode) {
		this.pincode = pincode;
	}

	public Customer getCustomer() {
		return customer;
	}

	public void setCustomer(Customer customer) {
		this.customer = customer;
	}

	public Set<Order> getOrder() {
		return order;
	}

	public void setOrder(Set<Order> order) {
		this.order = order;
	}

	
}