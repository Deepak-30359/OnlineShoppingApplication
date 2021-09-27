package com.shopping.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import com.shopping.entities.Customer;

public interface ICustomerRepository extends JpaRepository<Customer,Integer>{
	

}
