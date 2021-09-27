package com.shopping.controller;

import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;
import org.springframework.http.ResponseEntity;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import java.net.URI;

import javax.persistence.EntityNotFoundException;
import javax.validation.Valid;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.PathVariable;
import java.util.List;
import java.util.NoSuchElementException;

import org.springframework.web.bind.annotation.GetMapping;
import com.shopping.entities.Customer;
import com.shopping.services.CustomerServiceImpl;


@RestController
@RequestMapping("/customer")
public class CustomerController {
	@Autowired
	CustomerServiceImpl customerService;
	
	@PostMapping
	@ResponseStatus(HttpStatus.CREATED)
	public ResponseEntity<Customer> addCustomer(@Valid @RequestBody Customer cust){
		Customer cust1 = customerService.addCustomer(cust);
		URI location = ServletUriComponentsBuilder.fromCurrentRequest().path("/{customerid}")
				.buildAndExpand(cust1.getCustomerId())
				.toUri();
		return ResponseEntity.created(location).body(cust1);
	}
	
	@PutMapping
	public Customer updateCustomer(@RequestBody Customer cust) {
		return customerService.updateCustomer(cust);
	}
	
	@DeleteMapping("/{customerid}")
	public ResponseEntity<String> removeCustomerBycustomerId(@PathVariable int customerId){
		boolean flag = customerService.removeCustomerBycustomerId(customerId);
		if(flag)
			return new ResponseEntity<>("customer removed successfully", HttpStatus.OK);
		else
			return new ResponseEntity<>("customer not removed successfully", HttpStatus.BAD_REQUEST);
	}
	
	@GetMapping
	public List<Customer> viewAllCustomers(@RequestParam String location){
		return customerService.viewAllCustomers(location);
	}
	
	@GetMapping("/{customerid}")
	public Customer viewCustomerBycustomerId(@RequestParam int customerId) {
		try {
			return customerService.viewCustomerBycustomerId(customerId);
		}
		catch(EntityNotFoundException e) {
			throw new EntityNotFoundException("No customer by the id ");
		}
	}
	
}

