package com.shopping.services;

import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.beans.factory.annotation.Autowired;
import com.shopping.dao.ICustomerRepository;
import com.shopping.entities.Customer;
import java.util.List;
import java.util.NoSuchElementException;

import javax.persistence.EntityNotFoundException;

@Service
public class CustomerServiceImpl implements ICustomerService{
	@Autowired
	private ICustomerRepository repository;
	
	@Override
	public Customer addCustomer(Customer cust) {
		return repository.save(cust);
	}
	
	@Override
	public Customer updateCustomer(Customer cust) {
		Customer customer =repository.findById(cust.getCustomerId()).orElseThrow(
				() -> new EntityNotFoundException("no customer found by the id"));
		customer.setFirstName(cust.getFirstName());
		customer.setLastName(cust.getLastName());
		customer.setMobileNumber(cust.getMobileNumber());
		customer.setAddress(cust.getAddress());
		customer.setEmail(cust.getEmail());
		return repository.save(customer);
	}
	
	@Override
	public boolean removeCustomerBycustomerId(int customerId) {
		repository.findById(customerId).orElseThrow(
				() -> new EntityNotFoundException("No customer found, check id"));
		repository.deleteById(customerId);
		return true;
		
	}
	
	@Override
	public List<Customer> viewAllCustomers(String location) {
		return (List<Customer>)repository.findAll();
	}
	
	@Override
	public Customer viewCustomerBycustomerId(@RequestParam int customerId) {
		try {
		return repository.findById(customerId).get();
	}
		catch(NoSuchElementException e) {
			throw new NoSuchElementException("The Id does not exist");
		}
	}
	

}

