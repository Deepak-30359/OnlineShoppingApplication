package com.shopping;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.when;
import java.util.ArrayList;
import java.util.List;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import com.shopping.dao.ICustomerRepository;
import com.shopping.entities.Customer;
import com.shopping.services.CustomerServiceImpl;

@ExtendWith(MockitoExtension.class)
 class ICustomerServiceTest {
	@Mock
	private ICustomerRepository customerRepository;
	@InjectMocks
	private CustomerServiceImpl customerService;
	
	@Test
	void getAllCustomerTest() {
		List<Customer> list = new ArrayList<Customer>();
		Customer customer1 = new Customer(1, "Arnav", "Singh", "658396523", "arnav@gamil.com","Mumbai");
		Customer customer2 = new Customer(2, "Vikram", "Singh", "892345618", "vikram@gmail.com","Hyderabad");
		Customer customer3 = new Customer(3, "Rishi", "Varma", "964573281", "rishi@gmail.com","Banglore");
		list.add(customer1);
		list.add(customer2);
		list.add(customer3);
		
		when(customerRepository.findAll()).thenReturn(list);
		List<Customer> customerList = customerService.viewAllCustomers("Mumbai");
		assertEquals(3, customerList.size());
		
	}
	
	//add address
	@Test
	void saveCustomerTest() {
		Customer customer = new Customer(1, "Arnav", "Singh", "658396523", "arnav@gamil.com","Mumbai");
		when(customerRepository.save(customer)).thenReturn(customer);
		Customer savedCustomer = customerService.addCustomer(customer);
		assertThat(savedCustomer).isNotNull();
		assertEquals("Singh",savedCustomer.getLastName());
	}
	

}

