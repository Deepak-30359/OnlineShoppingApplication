package com.shopping.services;

import java.util.List;

import com.shopping.entities.Customer;

public interface ICustomerService {
	public Customer addCustomer(Customer cust);
	public Customer updateCustomer(Customer cust);
	public boolean removeCustomerBycustomerId(int customerId);
	public List<Customer> viewAllCustomers(String location);
	public Customer viewCustomerBycustomerId(int customerId);


}
